package com.dermacon.workshop.controller;

import com.dermacon.workshop.service.PersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.dermacon.workshop.exception.ErrorCode.ACCESS_DENIED;


@Controller
public class DefaultController extends ModelAttributeProvider {

    private static Logger log = Logger.getLogger(DefaultController.class);

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

//    @RequestMapping("/login")
//    public String getLoginView() {
//        return "public/login";
//    }

    @RequestMapping("/help")
    public String help() {
        return "help";
    }

    @RequestMapping("/contact")
    public String contactInfo() {
        return "contactInfo";
    }

    /**
     * https://stackoverflow.com/questions/20848312/how-to-correctly-logout-user-in-spring-security
     */
    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        log.info("logout");
        return "redirect:/login?logout"; //You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    @RequestMapping("/accessDenied")
    public String accessDenied(Model model) {
        model.addAttribute("errorCode", ACCESS_DENIED);
        return "error/error";
    }

}
