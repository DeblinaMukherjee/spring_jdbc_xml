package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.Student;
import com.cognizant.service.StudentServiceImpl;

@Controller
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;

	public void setStudentService(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value="insert",method=RequestMethod.GET)
	public String insertPage()
	{
		return "insert";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insert(HttpServletRequest request)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		Student student=new Student(id,name);
		System.out.println(student);
		String res=studentService.insert(new Student(id,name));
		
		if(res.equals("Success"))
			request.setAttribute("msg","Record Inserted Successfully");
		else
			request.setAttribute("msg","Record Not Inserted");	
		return "insert";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updatePage()
	{
		return "update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(HttpServletRequest request)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		Student student=new Student(id,name);
		System.out.println(student);
		String res=studentService.update(new Student(id,name));
		
		if(res.equals("Success"))
			request.setAttribute("msg","Record Updated Successfully");
		else
			request.setAttribute("msg","Record Not Updated");	
		return "update";
	}
	
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deletePage()
	{
		return "delete";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(HttpServletRequest request)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		String res=studentService.delete(id);
		
		if(res.equals("Success"))
			request.setAttribute("msg","Record Deleted Successfully");
		else
			request.setAttribute("msg","Record Not Deleted");	
		return "delete";
	}
	
	@RequestMapping(value="display",method={RequestMethod.GET,RequestMethod.POST})
	public String getAllPage(HttpServletRequest request)
	{
		List<Student> student=studentService.getAll();
		request.setAttribute("student",student);
		System.out.println(student);
	return "display";
	}
}
