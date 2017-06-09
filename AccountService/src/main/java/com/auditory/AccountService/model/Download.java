package com.auditory.AccountService.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Download", uniqueConstraints = @UniqueConstraint(columnNames = {"account", "downloadTime"}))
public class Download implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long downloadId;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "studentId", name = "student")
	private Student student;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "downloadTime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date downloadTime;
	
	@Column(nullable = false)
	private long audioId;

	@Transient
	private Audio audio;
	
	public Download()
	{
		
	}
	
	public Download(Student student, Date downloadTime, long audioId)
	{
		this.student = student;
		this.downloadTime = downloadTime;
		this.audioId = audioId;
	}
	
	public long getDownloadId()
	{
		return downloadId;
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
	
	public void setAudioId(long audioId)
	{
		this.audioId = audioId;
	}
	
	public long getAudioId()
	{
		return audioId;
	}

	public void setAudio(Audio audio)
	{
		this.audio = audio;
	}
	
	public Audio getAudio() {
		return audio;
	}
}