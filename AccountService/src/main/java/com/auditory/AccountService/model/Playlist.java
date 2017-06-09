package com.auditory.AccountService.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Playlist")
public class Playlist implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playlistId;
	
	@Column(nullable = false)
	private String playlistName;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeCreated;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "studentId")
	private Student student;
	
	@Column
	@ElementCollection(targetClass = Long.class)
	private List<Long> audioIds;
	
	@Transient
	private List<Audio> audios;
	
	public Playlist()
	{
		
	}
	
	public Playlist(String playlistName, Date dateCreated, Student student)
	{
		this.playlistName = playlistName;
		this.timeCreated = dateCreated;
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
		this.timeCreated = dateCreated;
	}
	
	public Date getDateCreated()
	{
		return timeCreated;
	}
	
	public void setStudent(Student student)
	{
		this.student = student;
	}
	
	public Student getStudent()
	{
		return student;
	}
	
	public void addAudioId(long audioId)
	{
		this.audioIds.add(audioId);
	}
	
	public void removeAudioId(long audioId)
	{
		this.audioIds.remove(audioId);
	}

	public List<Long> getAudioIds() {
		return audioIds;
	}

	public void setAudiosIds(List<Long> audiosId) {
		this.audioIds = audiosId;
	}

	public List<Audio> getAudios() {
		return audios;
	}

	public void setAudios(List<Audio> audios) {
		this.audios = audios;
	}
}
