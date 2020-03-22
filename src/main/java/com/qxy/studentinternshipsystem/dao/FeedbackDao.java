package com.qxy.studentinternshipsystem.dao;


import com.qxy.studentinternshipsystem.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedbackDao {
    void insertFeedback(Feedback feedback);

    List<Feedback> getAllFeedback();

    void delete(String userId);
}
