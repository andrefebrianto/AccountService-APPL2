package com.auditory.AccountService.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Audio")
public class Audio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long audioId;
	
	@Column(nullable = false)
	private String audioTitle;
	
	@Column(nullable = false)
	private int length;
	
	@Column(nullable = false)
	private String filePath;
	
	public Audio()
	{
		
	}
	
	public Audio(String audioTitle, int length, String filePath)
	{
		this.audioTitle = audioTitle;
		this.length = length;
		this.filePath = filePath;
	}
	
	public long getAudioId()
	{
		return audioId;
	}
	
	public void setAudioTitle(String audioTitle)
	{
		this.audioTitle = audioTitle;
	}
	
	public String getAudioTitle()
	{
		return audioTitle;
	}
	
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}
	
	public String getFilePath()
	{
		return filePath;
	}
}