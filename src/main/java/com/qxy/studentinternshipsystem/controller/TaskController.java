package com.qxy.studentinternshipsystem.controller;


import com.qxy.studentinternshipsystem.entity.Task;
import com.qxy.studentinternshipsystem.service.TaskService;
import com.qxy.studentinternshipsystem.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/insertTask" , method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage insertTask(@RequestBody Task task){
        task.setTaskId(UUID.randomUUID().toString());
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        task.setTaskTime(df.format(new Date()));
        try {

            taskService.insertTask(task);
            return new ResponseMessage("1","发布成功");

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","发布失败");
        }
    }



    @RequestMapping(value = "/getAllTask" )
    public @ResponseBody
    ResponseMessage getAllTask(){

        try {

            List<Task> taskList = taskService.getAllTask();
            ResponseMessage responseMessage =  new ResponseMessage("1","获取成功");
            responseMessage.getData().put("taskList",taskList);
            return responseMessage;

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }
    }

    @RequestMapping(value = "/deleteTask" )
    public @ResponseBody
    ResponseMessage deleteTask(String taskId){

        try {

            taskService.deleteTask(taskId);
            return new ResponseMessage("1","删除成功");

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","删除失败");
        }
    }
}
