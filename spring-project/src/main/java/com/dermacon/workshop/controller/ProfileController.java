package com.dermacon.workshop.controller;

import com.dermacon.workshop.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("profile")
public class ProfileController extends ModelAttributeProvider {

    private static final String SPECIFIC_PATH = "/profile/specific/";

    private PersonService personService;

    /* ---------- Courses overview ---------- */

    @RequestMapping(value = {"/", "/all"})
    public String showAllProfiles(Model model) {
        System.out.println("todo: /showAllProfiles");
        return "index";
    }

    @RequestMapping(value = {"/admins"})
    public String showAllAdmins(Model model) {
        System.out.println("todo: /showAllAdmins");
        return "index";
    }

    @RequestMapping(value = {"/managers"})
    public String showAllManagers(Model model) {
        System.out.println("todo: /showAllManagers");
        return "index";
    }

    @RequestMapping(value = {"/specific"})
    public String showSpecificProfile(Model model, @RequestParam long personId) {
        System.out.println("todo: /showSpecificProfile=" + personId);

        model.addAttribute("selectedPerson", personService.getLoggedInPerson());
        return SPECIFIC_PATH + "specificProfile";
    }

}
