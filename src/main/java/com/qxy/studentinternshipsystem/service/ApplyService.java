package com.qxy.studentinternshipsystem.service;


import com.qxy.studentinternshipsystem.entity.Apply;

import java.util.List;

public interface ApplyService {
    void insertApply(Apply apply);

    List<Apply> getUserApply(String userId);

    List<Apply> getAllApplyByState();

    void updateApplyStateById(String applyId, String applyState);
}
