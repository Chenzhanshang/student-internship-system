package com.qxy.studentinternshipsystem.entity;

public class Announcement {
    private String announcementId;

    private User user;

    private String announcementContent;

    private String announcementTitle;

    private String announcementTime;

    public String getAnnouncementId() {
        return announcementId;
    }

    public String getAnnouncementTime() {
        return announcementTime;
    }

    public void setAnnouncementTime(String announcementTime) {
        this.announcementTime = announcementTime;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId == null ? null : announcementId.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent == null ? null : announcementContent.trim();
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle == null ? null : announcementTitle.trim();
    }
}