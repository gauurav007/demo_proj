package com.dao;

import java.util.ArrayList;

import com.model.Student;

public interface IDao 
{
	
	public Integer addStudent(Student stu);
	
	public boolean loginCheck(Student stu);
	
	public ArrayList<Student> getData();
	
	public Integer deleteStudent(Student stu);
	
	public Student editData(Integer id);
	
	public Integer updaData(Student stu);

}
