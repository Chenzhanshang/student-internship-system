package com.qxy.studentinternshipsystem.controller;


import com.qxy.studentinternshipsystem.entity.Feedback;
import com.qxy.studentinternshipsystem.service.FeedbackService;
import com.qxy.studentinternshipsystem.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @RequestMapping("/submitFeedback")
    public @ResponseBody
    ResponseMessage submitFeedback(@RequestBody Feedback feedback){
        System.out.println(feedback);
        feedback.setFeedbackId(UUID.randomUUID().toString());
        try {
            feedbackService.insertFeedback(feedback);
            return new ResponseMessage("1","提交反馈成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","提交反馈失败");
        }
    }

    @RequestMapping("getAllFeedback")
    public @ResponseBody ResponseMessage getAllFeedback(){
        try {
            List<Feedback> feedbackList = feedbackService.getAllFeedback();
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("feedbackList",feedbackList);
            return responseMessage;

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }
    }
}
