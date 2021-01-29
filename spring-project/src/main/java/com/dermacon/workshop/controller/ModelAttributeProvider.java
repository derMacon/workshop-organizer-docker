package com.dermacon.workshop.controller;

import com.dermacon.workshop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Superclass from which each Controller needs to inherit the ModelAttributes
 */
@Controller
public class ModelAttributeProvider {


    @Autowired
    private PersonService personService;

    @ModelAttribute("loggedInPerson")
    public void addAttributes(Model model) {
        model.addAttribute("loggedInPerson", personService.getLoggedInPerson());
    }

}
