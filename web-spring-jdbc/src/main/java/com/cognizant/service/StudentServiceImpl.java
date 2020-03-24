package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;


@Service
public class StudentServiceImpl implements StudentService {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	StudentDaoImpl dao=(StudentDaoImpl) ctx.getBean("sdao");
	
	
	public String insert(Student s) {
		
		return dao.insert(s);
	}

	public String delete(int id) {
		
		return dao.delete(id);
	}

	public String update(Student s) {
		
		return dao.update(s);
	}

	public List<Student> getAll() {
		
		return dao.getAll();
	}


}
