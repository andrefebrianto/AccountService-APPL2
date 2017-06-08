package com.auditory.AccountService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.repository.StudentRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getAll()
	{
		List<Student> student = null;
		try {
			student = repository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return student;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getByStudentId(@PathVariable("id") char id[])
	{
		Student student = null;
		try {
			student = repository.findOne(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return student;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Student saveAccount(@RequestBody Student student)
	{
		try {
			repository.save(student);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return student;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteByStudentId(@PathVariable("id") char id[])
	{
		try {
			repository.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}		
	}
}
