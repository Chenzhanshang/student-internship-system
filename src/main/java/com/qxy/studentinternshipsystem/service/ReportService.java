package com.qxy.studentinternshipsystem.service;


import com.qxy.studentinternshipsystem.entity.Report;

import java.util.List;

public interface ReportService {
    void insertReport(Report report);

    List<Report> getUserReport(String userId);

    List<Report> getAllReport();
}
