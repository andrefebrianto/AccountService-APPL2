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
		List<Playlist> playlists = playRepository.findAll();
		return playlists;
	}
	
	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public List<Playlist> getAllPlaylistByAccount(@PathVariable("accountId") char id[])
	{
		Student student = accRepository.findOne(id);
		List<Playlist> playlists = playRepository.findByStudent(student);
		return playlists;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Playlist createNewPlaylist(@RequestBody Playlist playlist)
	{
		playRepository.save(playlist);
		return playlist;
	}
	
	@RequestMapping(value = "/{accountId}/{playlistId}", method = RequestMethod.DELETE)
	public void deletePlaylistByPlaylistId(@PathVariable("playlistId") long id)
	{
		playRepository.delete(id);
	}
	
	@RequestMapping(value = "/{accountId}/{playlistId}", method = RequestMethod.GET)
	public List<Audio> getAllAudioByPlaylistId(@PathVariable("playlistId") long id)
	{
		Playlist playlist = playRepository.findOne(id);
		return playlist.getAudios();		
	}
/*	
	@RequestMapping(value = "/{accountId}/{playlistId}/{audioId}", method = {RequestMethod.POST, RequestMethod.PUT})
	public Audio addAudioToPlaylist(@PathVariable("audioId") long audioId, 
			@PathVariable("playlistId") long id)
	{
		Audio audio = audRepository.findOne(audioId);
		Playlist playlist = playRepository.findOne(id);
		playlist.addAudio(audio);
		playRepository.save(playlist);
		return audio;
	}
*/
	@RequestMapping(value = "/{accountId}/{playlistId}/{audioId}", method = RequestMethod.DELETE)
	public void removeAudioFromPlaylist(@PathVariable("audioId") long audioId, 
			@PathVariable("playlistId") long playlistId)
	{
		Audio audio = audRepository.findOne(audioId);
		Playlist playlist = playRepository.findOne(playlistId);
		playlist.removeAudio(audio);
		playRepository.save(playlist);
	}
}
