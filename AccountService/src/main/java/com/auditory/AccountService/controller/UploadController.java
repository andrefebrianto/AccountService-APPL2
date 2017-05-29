package com.auditory.AccountService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.model.Upload;
import com.auditory.AccountService.repository.StudentRepository;
import com.auditory.AccountService.repository.AudioRepository;
import com.auditory.AccountService.repository.UploadRepository;

@RestController
@RequestMapping(value = "/upload")
public class UploadController {
	@Autowired
	UploadRepository upRepository;
	
	@Autowired
	StudentRepository accRepository;
	
	@Autowired
	AudioRepository audRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Upload> getAllUpload()
	{
		List<Upload> uploads = null;
		try {
			uploads = upRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return uploads;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Upload> getAllUploadByStudentId(@PathVariable("id") char id[])
	{
		List<Upload> uploads = null;
		try {
			Student student = accRepository.findOne(id);
			uploads = upRepository.findByStudent(student);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return uploads;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Upload saveUpload(@RequestBody Upload upload)
	{	
		try {
			upRepository.save(upload);
		} catch (Exception e) {
			// TODO: handle exception\
			System.err.println(e);
		}
		return upload;
	}
}
