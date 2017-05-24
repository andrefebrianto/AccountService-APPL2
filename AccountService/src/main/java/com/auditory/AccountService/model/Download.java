package com.auditory.AccountService.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Download", uniqueConstraints = @UniqueConstraint(columnNames = {"account", "downloadTime"}))
public class Download implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long downloadId;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "studentId", name = "account")
	private Student student;
	
	@Column(name = "downloadTime", nullable = false)
	private Date downloadTime;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "audioId")
	private Audio audio;
	
	public Download()
	{
		
	}
	
	public Download(Student student, Date downloadTime, Audio audio)
	{
		this.student = student;
		this.downloadTime = downloadTime;
		this.audio = audio;
	}
	
	public void setStudent(Student student)
	{
		this.student = student;
	}
	
	public Student getStudent()
	{
		return student;
	}
	
	public void setDownloadTime(Date downloadTime)
	{
		this.downloadTime = downloadTime;
	}
	
	public Date getDownloadTime()
	{
		return downloadTime;
	}
	
	public void setAudio(Audio audio)
	{
		this.audio = audio;
	}
	
	public Audio getAudio()
	{
		return audio;
	}
}