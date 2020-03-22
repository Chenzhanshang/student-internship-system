package com.qxy.studentinternshipsystem.service.impl;

import com.qxy.studentinternshipsystem.dao.FileDao;
import com.qxy.studentinternshipsystem.entity.File;
import com.qxy.studentinternshipsystem.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;
    @Override
    public void insertFile(File file1) {
        fileDao.insertFile(file1);
    }

    @Override
    public List<File> getAllFile(Integer type) {
        return fileDao.getAllFile(type);
    }

    @Override
    public void updateFile(File file) {
        fileDao.updateFile(file);
    }

    @Override
    public void deleteFile(String fileId) {
        fileDao.deleteFile(fileId);
    }
}
