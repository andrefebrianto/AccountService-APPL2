package com.auditory.AccountService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.model.Download;
import com.auditory.AccountService.repository.StudentRepository;
import com.auditory.AccountService.repository.AudioRepository;
import com.auditory.AccountService.repository.DownloadRepository;

@RestController
@RequestMapping(value = "/download")
public class DownloadController {
	@Autowired
	DownloadRepository downRepository;
	
	@Autowired
	AudioRepository audRepository;
	
	@Autowired
	StudentRepository accRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Download> getAll()
	{
		List<Download> downloads = downRepository.findAll();
		return downloads;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Download> getDownloadByStudentId(@PathVariable("id") char id[])
	{
		Student student = accRepository.findOne(id);
		List<Download> downloads = downRepository.findByStudent(student);
		return downloads;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Download saveDownload(@RequestBody Download download)
	{
		downRepository.save(download);
		return download;
	}
}
