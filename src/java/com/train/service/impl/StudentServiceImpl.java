package com.train.service.impl;

import com.train.common.service.CommonService;
import com.train.convert.Convert;
import com.train.model.StudentModel;
import com.train.model.data.StudentData;
import com.train.model.form.StudentForm;
import com.train.page.Pagination;
import com.train.page.SearchResult;
import com.train.dao.StudentDao;
import com.train.service.StudentServcie;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentServcie {

    private CommonService commonService;
    private StudentDao studentDao;
    private Convert<StudentModel, StudentData> studentConvert;
    private Convert<StudentForm, StudentModel> convertFrom2model;

    @Override
    public SearchResult<StudentData> findAll(StudentForm studentForm, Pagination pagination) {
        Map<String, Object> params = new HashMap<>();
        if(StringUtils.isNotBlank(studentForm.getName())){
            params.put(StudentModel.NAME, studentForm.getName());
        }
        if(StringUtils.isNotBlank(studentForm.getClazz())){
            params.put(StudentModel.CLASS, studentForm.getClazz());
        }
        SearchResult<StudentModel> searchResults = studentDao.queryStudentByFields(params, pagination);
        SearchResult<StudentData> results = new SearchResult<>();
        List<StudentData> datas = new ArrayList<StudentData>();
        for(StudentModel model : searchResults.getResult()){
            datas.add(studentConvert.convert(model));
        }
        results.setPagination(pagination);
        results.setResult(datas);
        return results;
    }

    public CommonService getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Convert<StudentModel, StudentData> getStudentConvert() {
        return studentConvert;
    }

    public void setStudentConvert(Convert<StudentModel, StudentData> studentConvert) {
        this.studentConvert = studentConvert;
    }

    public Convert<StudentForm, StudentModel> getConvertFrom2model() {
        return convertFrom2model;
    }

    public void setConvertFrom2model(Convert<StudentForm, StudentModel> convertFrom2model) {
        this.convertFrom2model = convertFrom2model;
    }
}
