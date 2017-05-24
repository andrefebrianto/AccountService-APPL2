package com.auditory.AccountService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.AccountService.model.Audio;

public interface AudioRepository extends JpaRepository<Audio, Long> {
	public List<Audio> findByAudioTitle(String title);
}
