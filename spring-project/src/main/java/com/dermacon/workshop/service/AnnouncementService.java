package com.dermacon.workshop.service;

import com.dermacon.workshop.data.Announcement;
import com.dermacon.workshop.data.AnnouncementRepository;
import com.dermacon.workshop.data.Course;
import com.dermacon.workshop.data.form_input.FormAnnouncementInfo;
import com.dermacon.workshop.exception.AnnouncementNonExistentException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class AnnouncementService {

    private static Logger log = Logger.getLogger(AnnouncementService.class);

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private MailService mailService;

    /* ---------- announcements ---------- */

    public void createNewAnnouncement(Course course, FormAnnouncementInfo info) {

        Announcement announcement = new Announcement(
                info.getTitle(),
                info.getContent(),
                new Date(System.currentTimeMillis()),
                course
        );

        // save in database
        log.info("save announcement: " + announcement.getAnnouncementId());
        announcementRepository.save(announcement);

        mailService.sendAnnouncement(course.getParticipants(), announcement);
    }

    public void deleteAnnouncements(Set<Announcement> announcements) {
        announcements.stream().forEach(this::deleteAnnouncement);
    }

    public void deleteAnnouncement(long id) throws AnnouncementNonExistentException {
        Optional<Announcement> announcementOpt = announcementRepository.findById(id);
        if (!announcementOpt.isPresent()) {
            throw new AnnouncementNonExistentException();
        }
        deleteAnnouncement(announcementOpt.get());
    }

    public void deleteAnnouncement(Announcement announcement) {
        announcement.setCourse(null);
        announcementRepository.delete(announcement);
    }

}
