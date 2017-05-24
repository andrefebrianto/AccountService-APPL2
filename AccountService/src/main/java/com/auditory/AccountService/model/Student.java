package com.auditory.AccountService.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private char[] studentId = new char[9];
	
	@Column(unique=true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	public Student()
	{
		studentId = new char[9];
	}
	
	public Student(char[] studentId, String email, String name, String password)
	{
		this.studentId = studentId;
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
	public void setStudentId(char[] studentId)
	{
		this.studentId = studentId;
	}
	
	public char[] getStudentId()
	{
		return studentId;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
}
