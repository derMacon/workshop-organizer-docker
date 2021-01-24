package com.dermacon.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/test")
    public String test() {
        userRepository.save(new Users("testinput1"));
        List<String> result = new ArrayList<String>();
        userRepository.findAll().forEach(e -> result.add(e.getUsername()));
        return "test1: " + result;
    }

}
