package com.qxy.studentinternshipsystem.service.impl;

import com.qxy.studentinternshipsystem.dao.TaskDao;
import com.qxy.studentinternshipsystem.entity.Task;
import com.qxy.studentinternshipsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    @Override
    public void insertTask(Task task) {
        taskDao.insertTask(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskDao.getAllTask();
    }

    @Override
    public void deleteTask(String taskId) {
        taskDao.deleteTask(taskId);
    }
}
