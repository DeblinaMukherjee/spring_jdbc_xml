package com.cognizant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HelloController {
		
	@RequestMapping(value="hello",method=RequestMethod.GET)
	public String sayHello()
	{
		return "hello";
	}
	
	@RequestMapping(value="hi",method=RequestMethod.GET)
	public String sayHelloByName(HttpServletRequest request)
	{
		
		String name=request.getParameter("name");
		System.out.println("Name: "+name);
		request.setAttribute("name",name);
		return "hi";
	}

	/*@RequestMapping(value="display",method=RequestMethod.GET)
	public String getAll()
	{
		List<Student> list=studentService.getAll();
		
		System.out.println("list "+list);
		return "display";
	}*/
}
