package com.qxy.studentinternshipsystem.dao;

import com.qxy.studentinternshipsystem.entity.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileDao {
    public void insertFile(File file1);

    List<File> getAllFile(Integer type);

    void updateFile(File file);

    void deleteFile(String fileId);
}
