package com.auditory.AccountService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Audio{
	
    private long audioId;
	private String audioTitle;
	private int length;
	private String filePath;
	
	public Audio()
	{
		
	}
	
	public Audio(long audioId)
	{
		this.audioId = audioId;
	}
	
	public Audio(long audioId, String audioTitle, int length, String filePath)
	{
		this.audioId = audioId;
		this.audioTitle = audioTitle;
		this.length = length;
		this.filePath = filePath;
	}
	
	public void setAudioId(long audioId)
	{
		this.audioId = audioId;
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