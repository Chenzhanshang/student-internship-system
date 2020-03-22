package com.qxy.studentinternshipsystem.service;

import com.qxy.studentinternshipsystem.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    void insertFeedback(Feedback feedback);

    List<Feedback> getAllFeedback();
}
