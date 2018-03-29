package com.train.convert.impl;

import java.util.Date;

import com.train.convert.Convert;
import com.train.model.StudentModel;
import com.train.model.form.StudentForm;
import com.train.util.DateUtil;

public class StudentConvertForm2Model implements Convert<StudentForm, StudentModel> {

	@Override
	public StudentModel createTarget() {
		return new StudentModel();
	}

	@Override
	public StudentModel convert(StudentForm studentForm) {
		StudentModel studentModel = createTarget();
		studentModel.setAvailable(true);
		studentModel.setBirthday(DateUtil.getDateByString(studentForm.getBirthday()));
		studentModel.setClazz(studentForm.getClazz());
		studentModel.setCreateTime(new Date());
		studentModel.setId(studentForm.getId());
		studentModel.setModifyTime(new Date());
		studentModel.setName(studentForm.getName());
		return studentModel;
	}

}
