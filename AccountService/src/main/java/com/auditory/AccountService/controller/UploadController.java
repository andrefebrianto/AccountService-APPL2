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
		List<Upload> uploads = upRepository.findAll();
		return uploads;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Upload> getAllUploadByStudentId(@PathVariable("id") char id[])
	{
		Student student = accRepository.findOne(id);
		List<Upload> uploads = upRepository.findByStudent(student);
		return uploads;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Upload saveUpload(@RequestBody Upload upload)
	{
		upRepository.save(upload);
		return upload;
	}
}
