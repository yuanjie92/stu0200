package com.train.controller;

import com.sun.deploy.config.Config;
import com.train.model.data.StudentData;
import com.train.model.form.StudentForm;
import com.train.page.Pagination;
import com.train.page.SearchResult;
import com.train.service.StudentServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class StudentController {

    @Autowired
    private StudentServcie studentServcie;

    @RequestMapping("/loadStudentByFields")
    public String loadStudentByFields(Model model, StudentForm studentForm, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage){
        Pagination pagination = new Pagination();
        if(currentPage <= 0){
            currentPage = Integer.parseInt(Config.getStringProperty("page.currentPage"));
        }
        pagination.setCurrentPage(currentPage);
        pagination.setPageSize(Integer.parseInt(Config.getStringProperty("page.pageSize")));
        SearchResult<StudentData> searchResults = studentServcie.findAll(studentForm, pagination);
        model.addAttribute("searchResults", searchResults);
        return "users/students";
    }

}
