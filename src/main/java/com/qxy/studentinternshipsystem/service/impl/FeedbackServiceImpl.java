package com.qxy.studentinternshipsystem.service.impl;

import com.qxy.studentinternshipsystem.dao.FeedbackDao;
import com.qxy.studentinternshipsystem.entity.Feedback;
import com.qxy.studentinternshipsystem.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;
    @Override
    public void insertFeedback(Feedback feedback) {
        feedbackDao.insertFeedback(feedback);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackDao.getAllFeedback();
    }
}
