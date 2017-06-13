package com.auditory.AccountService.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.auditory.AccountService.model.Audio;
import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.model.Upload;
import com.auditory.AccountService.repository.StudentRepository;
import com.auditory.AccountService.repository.UploadRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/upload")
public class UploadController {
	@Autowired
	UploadRepository upRepository;
	
	@Autowired
	StudentRepository accRepository;
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Upload> getAllUpload()
	{
		List<Upload> uploads = null;
		try {
			uploads = upRepository.findAll();
			for (Upload upload : uploads) {
				upload.setAudio(restTemplate.getForObject("http://localhost:3333/audio/"+upload.getAudioId(), Audio.class));
			}
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
			for (Upload upload : uploads) {
				upload.setAudio(restTemplate.getForObject("http://localhost:3333/audio/"+upload.getAudioId(), Audio.class));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return uploads;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Upload saveUpload(@RequestBody Upload upload)
	{	
		if (upload.getUploadTime() == null)
			upload.setUploadTime(new Date());
		try {
			upRepository.save(upload);
		} catch (Exception e) {
			// TODO: handle exception\
			System.err.println(e);
		}
		return upload;
	}
}
