package com.auditory.AccountService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.model.PlayHistory;

public interface PlayHistoryRepository extends JpaRepository<PlayHistory, Long> {
	public List<PlayHistory> findByStudent(Student student);
}
