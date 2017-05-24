package com.auditory.AccountService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.AccountService.model.Student;

public interface StudentRepository extends JpaRepository<Student, char[]> {
	public List<Student> findByName(String name);
}
