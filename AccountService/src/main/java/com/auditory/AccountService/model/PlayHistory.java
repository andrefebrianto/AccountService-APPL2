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
@Table(name = "PlayHistory", uniqueConstraints = @UniqueConstraint(columnNames = {"account", "datePlayed"}))
public class PlayHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long playHistoryId;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "studentId", name = "account")
	private Student student;
	
	@Column(name = "datePlayed", nullable = false)
	private Date datePlayed;

	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "audioId")
	private Audio audio;

	public PlayHistory()
	{
		
	}
	
	public PlayHistory(Student student, Date datePlayed, Audio audio)
	{
		this.student = student;
		this.datePlayed = datePlayed;
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
	
	public void setDatePlayed(Date datePlayed)
	{
		this.datePlayed = datePlayed;
	}
	
	public Date getDatePlayed()
	{
		return datePlayed;
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
