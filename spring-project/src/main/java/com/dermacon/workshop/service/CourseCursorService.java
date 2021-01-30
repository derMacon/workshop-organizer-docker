package com.dermacon.workshop.service;

import com.dermacon.workshop.data.Announcement;
import com.dermacon.workshop.data.Course;
import org.springframework.stereotype.Service;

/**
 * Class serves as a cursor for the current course. It serves as a wrapper for the standard
 * course object but also holds a iterator for the currently displayed announcement. This is
 * needed, since the gui only displays one announcement at a time (on the main page of a specific
 * course). This could be avoided using javascript in the front end, but it seem kind of
 * complicated to implement using the thymeleaf templating engine.
 */
@Service
public class CourseCursorService {

    private Course currCourse;

    private int currAnnouncementIdx = 0;

    public Course getCurrCourse() {
        return currCourse;
    }

    public void setCurrCourse(Course currCourse) {
        this.currCourse = currCourse;
    }

    public Announcement getCurrAnnouncement() {
        return null;
    }

    public void turnNextAnnouncement() {

    }

    public void turnPrevAnnouncement() {

    }

}

