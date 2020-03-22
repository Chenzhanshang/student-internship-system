package com.qxy.studentinternshipsystem.service.impl;

import com.qxy.studentinternshipsystem.dao.ApplyDao;
import com.qxy.studentinternshipsystem.entity.Apply;
import com.qxy.studentinternshipsystem.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyDao applyDao;

    @Override
    public void insertApply(Apply apply) {
        applyDao.insertApply(apply);
    }

    @Override
    public List<Apply> getUserApply(String userId) {
        return applyDao.getUserApply(userId);
    }

    @Override
    public List<Apply> getAllApplyByState() {
        return applyDao.getAllApplyByState();
    }

    @Override
    public void updateApplyStateById(String applyId, String applyState) {
        applyDao.updateApplyStateById(applyId, applyState);
    }
}
