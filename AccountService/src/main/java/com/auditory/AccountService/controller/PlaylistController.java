package com.auditory.AccountService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.model.Audio;
import com.auditory.AccountService.model.Playlist;
import com.auditory.AccountService.repository.StudentRepository;
import com.auditory.AccountService.repository.AudioRepository;
import com.auditory.AccountService.repository.PlaylistRepository;

@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {
	@Autowired
	PlaylistRepository playRepository;
	
	@Autowired
	StudentRepository accRepository;
	
	@Autowired
	AudioRepository audRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Playlist> getAllPlaylist()
	{
		List<Playlist> playlists = null;
		try {
			playlists = playRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return playlists;
	}
	
	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public List<Playlist> getAllPlaylistByAccount(@PathVariable("accountId") char id[])
	{
		List<Playlist> playlists = null;
		try {
			Student student = accRepository.findOne(id);
			playlists = playRepository.findByStudent(student);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return playlists;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Playlist createNewPlaylist(@RequestBody Playlist playlist)
	{	
		try {
			playRepository.save(playlist);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return playlist;
	}
	
	@RequestMapping(value = "/{accountId}/{playlistId}", method = RequestMethod.DELETE)
	public void deletePlaylistByPlaylistId(@PathVariable("playlistId") long id)
	{	
		try {
			playRepository.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	
	@RequestMapping(value = "/{accountId}/{playlistId}", method = RequestMethod.GET)
	public List<Audio> getAllAudioByPlaylistId(@PathVariable("playlistId") long id)
	{
		Playlist playlist = null;
		try {
			playlist = playRepository.findOne(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return playlist.getAudios();		
	}

	@RequestMapping(value = "/{accountId}/{playlistId}/{audioId}", method = RequestMethod.DELETE)
	public void removeAudioFromPlaylist(@PathVariable("audioId") long audioId, 
			@PathVariable("playlistId") long playlistId)
	{
		Playlist playlist = null;
		try {
			Audio audio = audRepository.findOne(audioId);
			playlist = playRepository.findOne(playlistId);
			playlist.removeAudio(audio);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		playRepository.save(playlist);
	}
}
