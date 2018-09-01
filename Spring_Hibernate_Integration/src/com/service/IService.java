package com.service;

import java.util.ArrayList;

import com.model.Student;

public interface IService 
{
	public Integer addStudent(Student stu);
	
	public boolean loginCheck(Student stu);
	
	public ArrayList<Student> getData();
	
	public Integer deleteStudent(Student stu);
	
	public Student editData(Integer id);
	
	public Integer updaData(Student stu);

}
