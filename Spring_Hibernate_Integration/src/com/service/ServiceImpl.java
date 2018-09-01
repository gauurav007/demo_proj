package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DaoImpl;
import com.model.Student;


@Service
public class ServiceImpl implements IService
{

	//HibernateTransactionManager
	
	/*@Autowired
	
	*/
	@Autowired
	DaoImpl dao;
	
	public Integer addStudent(Student stu) {
		// TODO Auto-generated method stub
		
		System.out.println("in service method");
		
		return dao.addStudent(stu);
	}

	public boolean loginCheck(Student stu) {
		// TODO Auto-generated method stub
		return dao.loginCheck(stu);
	}

	public ArrayList<Student> getData() 
	{
		// TODO Auto-generated method stub
		
		System.out.println("in service to read data");
		return dao.getData();
	}

	public Integer deleteStudent(Student stu) 
	{

		System.out.println("in delete method of service");
		
		return dao.deleteStudent(stu);
	}

	public Student editData(Integer id) 
	{
		// TODO Auto-generated method stub
		System.out.println("in edit data controller");
		
		return dao.editData(id);
	}

	public Integer updaData(Student stu) {
		// TODO Auto-generated method stub
		
		System.out.println("in update data of service");
		
		return dao.updaData(stu);
	}
	

}
