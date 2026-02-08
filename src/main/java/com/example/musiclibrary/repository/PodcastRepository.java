package com.example.musiclibrary.repository;

import com.example.musiclibrary.model.Podcast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastRepository extends JpaRepository<Podcast, Long> {
}
