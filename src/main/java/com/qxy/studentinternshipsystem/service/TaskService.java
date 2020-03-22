package com.qxy.studentinternshipsystem.service;


import com.qxy.studentinternshipsystem.entity.Task;

import java.util.List;

public interface TaskService {
    void insertTask(Task task);

    List<Task> getAllTask();

    void deleteTask(String taskId);
}
