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

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.model.Audio;
import com.auditory.AccountService.model.Download;
import com.auditory.AccountService.repository.StudentRepository;
import com.auditory.AccountService.repository.DownloadRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/download")
public class DownloadController {
	@Autowired
	DownloadRepository downRepository;
	
	@Autowired
	StudentRepository accRepository;
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Download> getAll()
	{
		List<Download> downloads = null;
		try {
			downloads = downRepository.findAll();
			for (Download download : downloads) {
				download.setAudio(restTemplate.getForObject("http://localhost:3333/audio/"+download.getAudioId(), Audio.class));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return downloads;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Download> getDownloadByStudentId(@PathVariable("id") char id[])
	{
		List<Download> downloads = null;
		try {
			Student student = accRepository.findOne(id);
			downloads = downRepository.findByStudent(student);
			for (Download download : downloads) {
				download.setAudio(restTemplate.getForObject("http://localhost:3333/audio/"+download.getAudioId(), Audio.class));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return downloads;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Download saveDownload(@RequestBody Download download)
	{
		if(download.getDownloadTime() == null)
			download.setDownloadTime(new Date());
		try {
			downRepository.save(download);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}	
		return download;
	}
}
