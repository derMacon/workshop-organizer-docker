package com.dermacon.workshop.service;

import com.dermacon.workshop.data.Course;
import com.dermacon.workshop.data.Meeting;
import com.dermacon.workshop.data.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    public Iterable<Meeting> getAllMeetings(Course course) {
        return meetingRepository.findAllByCourse(course);
    }

}
