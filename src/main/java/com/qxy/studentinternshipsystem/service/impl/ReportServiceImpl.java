package com.qxy.studentinternshipsystem.service.impl;

import com.qxy.studentinternshipsystem.dao.ReportDao;
import com.qxy.studentinternshipsystem.entity.Report;
import com.qxy.studentinternshipsystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;

    @Override
    public void insertReport(Report report) {
        reportDao.insertReport(report);
    }

    @Override
    public List<Report> getUserReport(String userId) {
        return reportDao.getUserReport(userId);
    }

    @Override
    public List<Report> getAllReport() {
        return reportDao.getAllReport();
    }
}
