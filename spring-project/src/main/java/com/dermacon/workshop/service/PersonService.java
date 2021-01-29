package com.dermacon.workshop.service;

import com.dermacon.workshop.data.AppUser;
import com.dermacon.workshop.data.AppUserRepository;
import com.dermacon.workshop.data.Person;
import com.dermacon.workshop.data.PersonRepository;
import com.dermacon.workshop.data.UserRole;
import com.dermacon.workshop.data.form_input.FormSignupInfo;
import com.dermacon.workshop.exception.EmailAlreadyExistsException;
import com.dermacon.workshop.exception.ErrorCodeException;
import com.dermacon.workshop.exception.UsernameAlreadyExistsException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.dermacon.workshop.data.UserRole.ROLE_USER;


@Service
public class PersonService {

    private static Logger log = Logger.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Checks if the currently logged in user has at least one of
     * the required permissions
     * @param role roles to check
     * @return true if the currently logged in user has at least one of
     * the required permissions
     */
    public boolean matchesAtLeastOneRole(UserRole... role) {
        UserRole currUser_role = getLoggedInUser().getRole();
        return Arrays.asList(role).stream()
                .filter(e -> e == currUser_role)
                .findAny().isPresent();
    }

    /**
     * Determines the currently logged in user
     * @return the currently logged in user
     */
    public Person getLoggedInPerson() {
        try {
            return personRepository.findByUser(getLoggedInUser());
        } catch (ClassCastException e) {
            return null;
        }
    }

    public AppUser getLoggedInUser() {
            // for some reason the id is always 0
            String username = ((AppUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal()).getUsername();

            return userRepository.findByUsername(username);
    }

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public void register(FormSignupInfo signupInfo) throws ErrorCodeException {
        if (personRepository.findByEmail(signupInfo.getEmail()) != null) {
            throw new EmailAlreadyExistsException();
        }

        if (userRepository.findByUsername(signupInfo.getUsername()) != null) {
            throw new UsernameAlreadyExistsException();
        }

        AppUser user = new AppUser.Builder()
                .username(signupInfo.getUsername())
                .password(passwordEncoder.encode(signupInfo.getPassword()))
                .role(ROLE_USER)
                .build();

        Person person = new Person.Builder()
                .email(signupInfo.getEmail())
                .firstname(signupInfo.getFirstname())
                .surname(signupInfo.getSurname())
                .user(user)
                .build();


        personRepository.save(person);
        mailService.sendAccountConfirmation(person);
    }

    // todo check if needed
    /**
     * list of hosts to pick from while creating new course
     * @return list of hosts to pick from while creating new course
     */
//    public Iterable<Person> getPossibleHosts() {
//        Set<User> users = userRepository.findAllByRole(UserRole.ROLE_ADMIN);
//        users.addAll(userRepository.findAllByRole(UserRole.ROLE_MANAGER));
//
//        // list of hosts to pick from while creating new course
//        Iterable<Person> possible_hosts = users.stream()
//                .map(personRepository::findByUser)
//                .collect(Collectors.toList());
//
//        return possible_hosts;
//    }

}
