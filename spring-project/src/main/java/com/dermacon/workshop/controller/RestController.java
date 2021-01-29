package com.dermacon.workshop.controller;

import com.dermacon.workshop.data.Announcement;
import com.dermacon.workshop.data.AnnouncementRepository;
import com.dermacon.workshop.data.AppUserRepository;
import com.dermacon.workshop.data.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private CourseRepository courseRepository;


    @RequestMapping("/test")
    public String test() {
        List<String> result = new ArrayList<String>();
        courseRepository.findAll().forEach(e -> result.add(e.toString()));
        return "test1: " + result;
    }

}
