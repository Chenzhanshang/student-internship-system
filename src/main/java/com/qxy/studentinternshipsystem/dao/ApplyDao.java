package com.qxy.studentinternshipsystem.dao;


import com.qxy.studentinternshipsystem.entity.Apply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyDao {
    void insertApply(Apply apply);

    List<Apply> getUserApply(String userId);

    List<Apply> getAllApplyByState();

    void updateApplyStateById(String applyId, String applyState);

    void delete(String userId);
}
