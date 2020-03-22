package com.qxy.studentinternshipsystem.controller;

import com.qxy.studentinternshipsystem.entity.Apply;
import com.qxy.studentinternshipsystem.service.ApplyService;
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
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    //发起申请
    @RequestMapping(value = "/insertApply", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage insertApply(@RequestBody Apply apply){
        apply.setApplyId(UUID.randomUUID().toString());
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        apply.setApplyTime(df.format(new Date()));

        //默认状态申请中
        apply.setState("申请中");
        try {
            applyService.insertApply(apply);
            return new ResponseMessage("1","提交成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","提交失败");
        }
    }

    //获取当前用户的所有申请
    @RequestMapping("/getUserApply")
    public @ResponseBody ResponseMessage getUserApply(String userId){
        try {
            List<Apply> applyList = applyService.getUserApply(userId);
            ResponseMessage responseMessage =  new ResponseMessage("1","获取成功");
            responseMessage.getData().put("applyList",applyList);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }
    }

    //获取所有状态为“申请中”的申请
    @RequestMapping("/getAllApplyByState")
    public @ResponseBody ResponseMessage getAllApplyByState(){
        try {
            List<Apply> applyList = applyService.getAllApplyByState();
            ResponseMessage responseMessage =  new ResponseMessage("1","获取成功");
            responseMessage.getData().put("applyList",applyList);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }
    }

    //通过申请
    @RequestMapping("/pass")
    public @ResponseBody ResponseMessage pass(String applyId){
        String applyState = "通过";
        try {
            applyService.updateApplyStateById(applyId,applyState);
            return new ResponseMessage("1","处理成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","处理失败");
        }
    }



    //驳回申请
    @RequestMapping("/reject")
    public @ResponseBody ResponseMessage reject(String applyId){
        String applyState = "拒绝";
        try {
            applyService.updateApplyStateById(applyId,applyState);
            return new ResponseMessage("1","处理成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","处理失败");
        }
    }
}
