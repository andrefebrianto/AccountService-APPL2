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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PlayHistory", uniqueConstraints = @UniqueConstraint(columnNames = {"student", "datePlayed"}))
public class PlayHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playHistoryId;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "studentId", name = "student")
	private Student student;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "datePlayed", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timePlayed;

	//@ManyToOne(optional = false)
	//@JoinColumn(referencedColumnName = "audioId")
	private long audioId;

	@Transient
	private Audio audio;
	
	public PlayHistory()
	{
		
	}
	
	public PlayHistory(Student student, Date datePlayed, Audio audio)
	{
		this.student = student;
		this.timePlayed = datePlayed;
		this.audioId = audio.getAudioId();
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
		this.timePlayed = datePlayed;
	}
	
	public Date getDatePlayed()
	{
		return timePlayed;
	}

	public long getAudioId() {
		return audioId;
	}

	public void setAudioId(long audioId) {
		this.audioId = audioId;
	}

	public Audio getAudio() {
		return audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}
}
