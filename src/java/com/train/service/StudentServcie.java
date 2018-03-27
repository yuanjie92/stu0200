package com.train.service;

import com.train.model.data.StudentData;
import com.train.model.form.StudentForm;
import com.train.page.Pagination;
import com.train.page.SearchResult;

public interface StudentServcie {

    SearchResult<StudentData> findAll(StudentForm studentForm, Pagination pagination);
}
