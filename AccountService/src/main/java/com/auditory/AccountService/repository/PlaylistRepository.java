package com.auditory.AccountService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.AccountService.model.Student;
import com.auditory.AccountService.model.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
	public List<Playlist> findByStudent(Student student);
}
