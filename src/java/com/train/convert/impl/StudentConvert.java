package com.train.convert.impl;


import com.train.convert.Convert;
import com.train.dao.StudentDao;
import com.train.model.StudentModel;
import com.train.model.data.StudentData;

public class StudentConvert implements Convert<StudentModel, StudentData> {

    @Override
    public StudentData createTarget() {
        return new StudentData();
    }

    @Override
    public StudentData convert(StudentModel model) {
        StudentData data = createTarget();
        data.setId(model.getId());
        data.setName(model.getName());
        data.setAvailable(model.isAvailable());
        data.setBirthday(model.getBirthday());
        data.setClazz(model.getClazz());
        data.setCreateTime(model.getCreateTime());
        data.setModifyTime(model.getModifyTime());
        return data;
    }

}
