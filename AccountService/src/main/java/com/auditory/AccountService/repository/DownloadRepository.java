package com.auditory.AccountService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.model.Download;

public interface DownloadRepository extends JpaRepository<Download, Long> {
	public List<Download> findByStudent(Student student);
}
