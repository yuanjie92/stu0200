package com.train.dao;

import com.train.model.StudentModel;
import com.train.page.Pagination;
import com.train.page.SearchResult;

import java.util.Map;

public interface StudentDao {

    SearchResult<StudentModel> queryStudentByFields(Map<String, Object> params, Pagination pagination);
}
