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
@Table(name = "Upload", uniqueConstraints = @UniqueConstraint(columnNames = {"account", "uploadTime"}))
public class Upload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uploadId;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "studentId", name = "account")
	private Student student;
	
	@Column(name = "uploadTime", nullable = false)
	private Date uploadTime;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "audioId")
	private Audio audio;
	
	public Upload()
	{
		
	}
	
	public Upload(Student student, Date uploadTime, Audio audio)
	{
		this.student = student;
		this.uploadTime = uploadTime;
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
	
	public void setUploadTime(Date uploadTime)
	{
		this.uploadTime = uploadTime;
	}
	
	public Date getUploadTime()
	{
		return uploadTime;
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