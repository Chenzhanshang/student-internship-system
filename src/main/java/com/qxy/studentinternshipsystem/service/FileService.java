package com.qxy.studentinternshipsystem.service;



import com.qxy.studentinternshipsystem.entity.File;

import java.util.List;

public interface FileService {
    void insertFile(File file1);

    List<File> getAllFile(Integer type);

    void updateFile(File file);

    void deleteFile(String fileId);
}
