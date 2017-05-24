package com.auditory.AccountService.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Playlist")
public class Playlist implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long playlistId;
	
	@Column(nullable = false)
	private String playlistName;
	
	@Column(nullable = false)
	private Date dateCreated;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "studentId")
	private Student student;
	
	@ManyToMany
	@JoinColumn(referencedColumnName = "audioId")
	private List<Audio> audios;
	
	public Playlist()
	{
		
	}
	
	public Playlist(String playlistName, Date dateCreated, Student student)
	{
		this.playlistName = playlistName;
		this.dateCreated = dateCreated;
		this.student = student;
	}
	
	public long getPlaylistId()
	{
		return playlistId;
	}
	
	public void setPlaylistName(String playlistName)
	{
		this.playlistName = playlistName;
	}
	
	public String getPlaylistName()
	{
		return playlistName;
	}
	
	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public void setStudent(Student student)
	{
		this.student = student;
	}
	
	public Student getStudent()
	{
		return student;
	}
	
	public void addAudio(Audio audio)
	{
		this.audios.add(audio);
	}
	
	public void removeAudio(Audio audio)
	{
		this.audios.remove(audio);
	}
	
	public List<Audio> getAudios()
	{
		return audios;
	}
	
	public void setAudios(List<Audio> audios)
	{
		this.audios = audios;
	}
}
