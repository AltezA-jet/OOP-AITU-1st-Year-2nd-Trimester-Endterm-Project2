package com.example.musiclibrary.service;

import com.example.musiclibrary.model.Podcast;
import com.example.musiclibrary.repository.PodcastRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodcastService {

    private final PodcastRepository podcastRepository;

    public PodcastService(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    public List<Podcast> getAll() {
        return podcastRepository.findAll();
    }

    public Podcast create(Podcast podcast) {
        return podcastRepository.save(podcast);
    }
}
