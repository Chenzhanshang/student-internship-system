package com.qxy.studentinternshipsystem.dao;

import com.qxy.studentinternshipsystem.entity.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskDao {
    void insertTask(Task task);

    List<Task> getAllTask();

    void deleteTask(String taskId);

    void delete(String userId);
}
