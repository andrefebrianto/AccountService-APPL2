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
import com.auditory.AccountService.model.PlayHistory;
import com.auditory.AccountService.repository.StudentRepository;
import com.auditory.AccountService.repository.PlayHistoryRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/playhistory")
public class PlayHistoryController {
	@Autowired
	PlayHistoryRepository phRepository;
	
	@Autowired
	StudentRepository accRepository;
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PlayHistory> getAll()
	{
		List<PlayHistory> histories = null;
		try {
			histories =phRepository.findAll();
			for (PlayHistory playHistory : histories) {
				playHistory.setAudio(restTemplate.getForObject("http://localhost:3333/audio/"+playHistory.getAudioId(), Audio.class));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return histories;
	}
	
	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
	public List<PlayHistory> findPlayHistoryByStudentId(@PathVariable("studentId") char studentId[])
	{
		List<PlayHistory> histories = null;
		try {
			Student student = accRepository.findOne(studentId);
			histories = phRepository.findByStudent(student);
			for (PlayHistory playHistory : histories) {
				playHistory.setAudio(restTemplate.getForObject("http://localhost:3333/audio/"+playHistory.getAudioId(), Audio.class));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return histories;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public PlayHistory savePlayHistory(@RequestBody PlayHistory playHistory)
	{
		if(playHistory.getDatePlayed() == null)
			playHistory.setDatePlayed(new Date());
		try {
			phRepository.save(playHistory);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return playHistory;
	}
}
