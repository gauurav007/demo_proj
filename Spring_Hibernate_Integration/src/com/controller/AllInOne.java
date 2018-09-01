package com.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Student;
import com.service.ServiceImpl;

@Controller
public class AllInOne 
{
	
	
	//BasicDataSource
	/*
	@Autowired
	ServiceImpl service;*/
	
	//LocalSessionFactoryBean
	//@Au
	@Autowired
	ServiceImpl service;
	
	@RequestMapping(value="/reg")
	public String displayReg(@ModelAttribute Student stu)
	{
		System.out.println("in reg method");
		
		System.out.println(stu.getId());
		
		Integer i = service.addStudent(stu);
		
		if(i>0)
		{
			return "login";
		}
		
		else
		{
			return "failure";
		}
		
		//return "register";
	}
	
	@RequestMapping(value="/log")
	public String login(@ModelAttribute Student stu,Model model)
	{
		System.out.println("in log method");
		
		System.out.println(stu.getUname()+" "+stu.getUpass());
		
		
		boolean status = service.loginCheck(stu);
		
		System.out.println("after validating from db status is");
		
		System.out.println(status);
		
		if(status)
		{
			System.out.println("reading whole data from controller");
			
			ArrayList<Student> stu_data = service.getData();
			
			model.addAttribute("data",stu_data);
			
			
			
			return "sucess";
		}
		else
		{
			return "failure";
		}
		
		
		
	}
	
	@RequestMapping(value="/deleteCurrentData")
	public String delete(@RequestParam("id") int id,Model model)
	{
		
		System.out.println("in delete method"+" "+id);
		
		Student s = new Student();
		s.setId(id);
	
		Integer Id =service.deleteStudent(s);
		
		if(Id>0)
		{
			ArrayList<Student> stu_adta = service.getData();
			
			model.addAttribute("data", stu_adta);
			
			return "sucess";
		}
		
		else
		{
			return "failure";
		}
		
		
	}
	
	@RequestMapping(value="/editCurrentData")
	public String editData(@RequestParam("id") int id,Model model)
	{
		
		System.out.println(id);
		
		System.out.println("in edit data controller");
		
		Student stu = service.editData(id);
		
		model.addAttribute("data", stu);
		
		return "update";
	}
	
	@RequestMapping(value="/register")
	public String displayReg()
	{
		
		System.out.println("in display reg");
		
		return "register";
	}
	
	@RequestMapping(value="/update")
	public String updateData(@ModelAttribute Student student,Model model)
	{
		
		System.out.println("in update data");
		Integer i = service.updaData(student);
		
		if(i>0)
		{
			ArrayList<Student> stu_data = service.getData();
			
			model.addAttribute("data", stu_data);
			
			return "sucess";
		}
		else
		{
			return "failure";
		}
			
		
	}
	
}