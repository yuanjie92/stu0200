package com.train.dao.impl;

import com.train.common.dao.CommonDao;
import com.train.dao.StudentDao;
import com.train.model.StudentModel;
import com.train.page.Pagination;
import com.train.page.SearchResult;

import java.util.Map;

public class StudentDaoImpl implements StudentDao {

    private CommonDao commonDao;

    @Override
    public SearchResult<StudentModel> queryStudentByFields(Map<String, Object> params, Pagination pagination) {
        return commonDao.getEntitiesByFields(StudentModel.class, params, null, pagination);
    }

    public CommonDao getCommonDao() {
        return commonDao;
    }

    public void setCommonDao(CommonDao commonDao) {
        this.commonDao = commonDao;
    }
}
