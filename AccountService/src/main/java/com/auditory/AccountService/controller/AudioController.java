package com.auditory.AccountService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.AccountService.model.Audio;
import com.auditory.AccountService.repository.AudioRepository;

@RestController
@RequestMapping(value = "/audio")
public class AudioController {
	@Autowired
	AudioRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Audio> getAudio(@RequestParam(value = "title", required = false) String title)
	{
		List<Audio> audios;
		if (title != null)
		{
			audios = repository.findByAudioTitle(title);
		}
		else
		{
			audios = repository.findAll();	
		}
		return audios;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Audio getByAudioId(@PathVariable("id") long id)
	{
		Audio audio = new Audio();
		audio = repository.findOne(id);
		return audio;
	}

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Audio saveAccount(@RequestBody Audio audio)
	{
		repository.save(audio);
		return audio;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteByStudentId(@PathVariable("id") long id)
	{
		repository.delete(id);
	}
}
