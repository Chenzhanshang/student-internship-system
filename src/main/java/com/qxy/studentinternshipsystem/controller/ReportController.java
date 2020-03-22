package com.qxy.studentinternshipsystem.controller;

import com.qxy.studentinternshipsystem.entity.Report;
import com.qxy.studentinternshipsystem.service.ReportService;
import com.qxy.studentinternshipsystem.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/insertReport")
    public @ResponseBody
    ResponseMessage insertReport(@RequestBody Report report){
        report.setReportId(UUID.randomUUID().toString());

        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        report.setReportTime(df.format(new Date()));
        try {
            reportService.insertReport(report);
            return new ResponseMessage("1","上传成功");

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","上传失败");
        }

    }

    @RequestMapping("/getUserReport")
    public @ResponseBody
    ResponseMessage getUserReport(String userId){
        System.out.println(userId);

        try {
            List<Report> reportList = reportService.getUserReport(userId);
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("reportList", reportList);
            return responseMessage;

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }

    }


    @RequestMapping("/getAllReport")
    public @ResponseBody
    ResponseMessage getAllReport(){

        try {
            List<Report> reportList = reportService.getAllReport();
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("reportList", reportList);
            return responseMessage;

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }

    }
}
