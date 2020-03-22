package com.qxy.studentinternshipsystem.dao;

import com.qxy.studentinternshipsystem.entity.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportDao {
    void insertReport(Report report);

    List<Report> getUserReport(String userId);

    List<Report> getAllReport();

    void delete(String userId);
}
