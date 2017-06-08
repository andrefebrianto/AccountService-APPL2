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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Upload", uniqueConstraints = @UniqueConstraint(columnNames = {"account", "uploadTime"}))
public class Upload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uploadId;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "studentId", name = "account")
	private Student student;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "uploadTime", nullable = false)
	private Date uploadTime;

	private long audioId;
	
	@Transient
	private Audio audio;
	
	public Upload()
	{
		
	}
	
	public Upload(Student student, Date uploadTime, long audioId)
	{
		this.student = student;
		this.uploadTime = uploadTime;
		this.audioId = audioId;
	}
	
	public void setStudent(Student student)
	{
		this.student = student;
	}
	
	public Student getStudent()
	{
		return student;
	}
	
	public void setUploadTime(Date uploadTime)
	{
		this.uploadTime = uploadTime;
	}
	
	public Date getUploadTime()
	{
		return uploadTime;
	}
	
	public void setAudioId(long audioId)
	{
		this.audioId = audioId;
	}
	
	public long getAudioId()
	{
		return audioId;
	}

	public Audio getAudio() {
		return audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}
}