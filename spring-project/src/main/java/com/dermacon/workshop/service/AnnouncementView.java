package com.dermacon.workshop.service;

import com.dermacon.workshop.data.Announcement;
import com.dermacon.workshop.data.Course;
import com.dermacon.workshop.data.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementView {

    private Course course;
    private int currAnnouncementIdx = 0;

    @Autowired
    private CourseRepository courseRepository;


    public Course getCourse() {
        return course;
    }

    public Announcement getCurrAnnouncement() {
//        course.getAnnouncements()
        return null;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void reset() {
        currAnnouncementIdx = 0;
    }

    public void setToNextAnnouncement() {
        currAnnouncementIdx++;
//        currAnnouncementIdx = currAnnouncementIdx %
    }

    public void setToPrevAnnouncement() {

    }
}
