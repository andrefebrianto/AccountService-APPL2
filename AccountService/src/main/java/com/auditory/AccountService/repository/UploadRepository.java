package com.auditory.AccountService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.model.Upload;

public interface UploadRepository extends JpaRepository<Upload, Long> {
	public List<Upload> findByStudent(Student student);
}
