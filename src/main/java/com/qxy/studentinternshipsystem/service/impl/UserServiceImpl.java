package com.qxy.studentinternshipsystem.service.impl;

import com.qxy.studentinternshipsystem.dao.*;
import com.qxy.studentinternshipsystem.entity.Announcement;
import com.qxy.studentinternshipsystem.entity.User;
import com.qxy.studentinternshipsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private AnnouncementDao announcementDao;

    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private ReportDao reportDao;

    @Autowired
    private TaskDao taskDao;

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User getUserByUserNameAndPassword(User user) {

        return userDao.getUserByUserNameAndPassword(user);
    }

    @Override
    public void update(User user) {

        userDao.updateUser(user);
    }

    @Override
    public void updatePassword(User user) {
        userDao.updatePassword(user);
    }

    @Override
    public User getUserByUserMsg(User user) {
        return userDao.getUserByUserMsg(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void deleteUser(String userId) {
        announcementDao.delete(userId);
        applyDao.delete(userId);
        feedbackDao.delete(userId);
        reportDao.delete(userId);
        taskDao.delete(userId);
        userDao.deleteUser(userId);
    }

}
