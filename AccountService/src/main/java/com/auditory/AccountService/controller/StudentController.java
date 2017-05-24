package com.auditory.AccountService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.repository.StudentRepository;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getAll()
	{
		List<Student> student = repository.findAll();
		return student;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getByStudentId(@PathVariable("id") char id[])
	{
		Student student = repository.findOne(id);
		return student;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Student saveAccount(@RequestBody Student student)
	{
		repository.save(student);
		return student;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteByStudentId(@PathVariable("id") char id[])
	{
		repository.delete(id);
	}
}
