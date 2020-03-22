package com.qxy.studentinternshipsystem.dao;

import com.qxy.studentinternshipsystem.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementDao {
    void insertAnnouncement(Announcement announcement);

    List<Announcement> getAllAnnouncement();

    void updateAnnouncement(Announcement announcement);

    void deleteAnnouncement(String announcementId);

    void delete(String userId);
}
