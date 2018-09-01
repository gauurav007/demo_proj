package com.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Student;


@Repository
public class DaoImpl implements IDao
{
	
	/*@Autowired
	HibernateTemplate template;
	*/
	@Autowired
	HibernateTemplate template;

	@Autowired
	SessionFactory mySessionFactory;
	
	
public HibernateTemplate getTemplate()
{
		return template;
	}


	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}


/*	public void setSessionFactory(SessionFactory sessionFactory) 
    {
		this.template = new HibernateTemplate(sessionFactory);
	}

*/	public Integer addStudent(Student stu) {
		// TODO Auto-generated method stub
	
	int id = 0;
	
	System.out.println(stu.getId()+" "+
						stu.getFname()+" "
						+stu.getLname()+" "+
						stu.getUname()+" "+
						stu.getUpass());
	
	System.out.println("in dao method");
			//	template.getSessionFactory().getCurrentSession().save(stu);
	
	
		
	
	//template.getSessionFactory().getCurrentSession().getTransaction().begin();
	
	/*SessionFactory sf = template.getSessionFactory();
	
	Session ss = (Session) SessionFactory.openSession().beginTransaction();
	*/
	template.save(stu);
				System.out.println("data added");
				
				id = 1;
				
				return id;
				
	}


public boolean loginCheck(Student stu) {
	// TODO Auto-generated method stub

	System.out.println("in dao");
	
	boolean status = false;
	
	
	//template.find
	
	
	
	//List<Student> list =(List<Student>)template.getSessionFactory().getCurrentSession().createQuery("from student where uname='"+stu.getUname()+"' && upass='"+stu.getUpass()+"' ");
	
	Session session = mySessionFactory.openSession();
	
	Criteria criteria = session.createCriteria(Student.class);
	
	List<Student> list = (List<Student>)criteria.list();
	
	Iterator itr = list.iterator();
	
	while(itr.hasNext())
	{
		
		Student student = (Student)itr.next();
		
		if(student.getUname().equals(stu.getUname()) && student.getUpass().equals(stu.getUpass()))
		{
			status=true;
		}
		
	}
	
	
	/*Query query = session.createQuery("from student where uname=? and upass=?");
	query.setString(0, stu.getUname());
	query.setString(1, stu.getUpass());
	List<Student> list = (List<Student>)query.list();*/
	
				
	//template.cr
	
	/*String sql = "select from student where uname='"+stu.getUname()+"' and upass='"+stu.getUpass()+"'  ";
		
	List<Student> list = (List<Student>)template.find(sql,null);
	*//*
	Query query =  (Query) template.findByNamedQuery("sql");
	query.setString(0, stu.getUname());
	query.setString(1, stu.getUpass());
	 
	System.out.println("executed");
	*/	
	
		
		
	
	
	return status;
}


public ArrayList<Student> getData() 
{
	// TODO Auto-generated method stub
	
	System.out.println("in dao to read data");
	
	Session session = mySessionFactory.openSession();
	
	//Criteria criteria = session.createCriteria(Student.class);
	
	Query query = session.createQuery("from Student");
	
	ArrayList<Student> liststu = (ArrayList<Student>)query.list();

	
	Iterator itr = liststu.iterator();
	
	while(itr.hasNext())
	{
		Student s = (Student)itr.next();
		
		System.out.println(s.getFname()+" "+s.getLname());
	}
	
	
	return liststu;
}


public Integer deleteStudent(Student stu) 
{
	System.out.println("delete of dao");
	
	Integer id = 0;
	
	int myid = stu.getId();
	
	System.out.println(myid);
	
	Session session = mySessionFactory.openSession();
	
	//session.delete("delete from Student where id = "+stu.getId()+" ");
	
	
	Student s = (Student)session.get(Student.class, myid);
	session.delete(s);
	session.beginTransaction().commit();		
	
	//Student s = (Student)session.delete(Student.class, stu.getId());
	
	/*Query query = session.createQuery("delete from Student where id = "+stu.getId()+" ");
	
	query.list();
	*/
	id = 1;
	
	
	return id;
}


public Student editData(Integer id) 
{

	
	System.out.println("edit data of dao");
	
	Session session = mySessionFactory.openSession();
	
	Student stu  = (Student)session.get(Student.class, id);
	
	return stu;
}


public Integer updaData(Student stu) 
{
	Integer id = 0;
	
	System.out.println("in update data of dao");
	
	Session session = mySessionFactory.openSession();
	
	Student s = (Student)session.get(Student.class, stu.getId());
	s.setId(stu.getId());
	s.setFname(stu.getFname());
	s.setLname(stu.getLname());
	s.setUname(stu.getUname());
	s.setUpass(stu.getUpass());
	
	
	session.update(s);
	session.beginTransaction().commit();
	
	System.out.println("data updated");
	
	id = 1;
	
	return id;
}
	

}
