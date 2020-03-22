package com.qxy.studentinternshipsystem.service;


import com.qxy.studentinternshipsystem.entity.Announcement;

import java.util.List;

public interface AnnouncementService {

    void insertAnnouncement(Announcement announcement);

    List<Announcement> getAllAnnouncement();

    void updateAnnouncement(Announcement announcement);

    void deleteAnnouncement(String announcementId);
}
