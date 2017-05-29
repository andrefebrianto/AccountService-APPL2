package com.auditory.AccountService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.model.PlayHistory;
import com.auditory.AccountService.repository.StudentRepository;
import com.auditory.AccountService.repository.AudioRepository;
import com.auditory.AccountService.repository.PlayHistoryRepository;

@RestController
@RequestMapping(value = "/playhistory")
public class PlayHistoryController {
	@Autowired
	PlayHistoryRepository phRepository;
	
	@Autowired
	StudentRepository accRepository;
	
	@Autowired
	AudioRepository audRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PlayHistory> getAll()
	{
		List<PlayHistory> history = null;
		try {
			history =phRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return history;
	}
	
	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
	public List<PlayHistory> findPlayHistoryByStudentId(@PathVariable("studentId") char studentId[])
	{
		List<PlayHistory> playHistory = null;
		try {
			Student student = accRepository.findOne(studentId);
			playHistory = phRepository.findByStudent(student);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return playHistory;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public PlayHistory savePlayHistory(@RequestBody PlayHistory playHistory)
	{
		try {
			phRepository.save(playHistory);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return playHistory;
	}
}
