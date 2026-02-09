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

    public Podcast create(Podcast podcast) {
        return podcastRepository.save(podcast);
    }

    public List<Podcast> getAll() {
        return podcastRepository.findAll();
    }

    public Podcast getById(Long id) {
        return podcastRepository.findById(id).orElseThrow();
    }

    public Podcast update(Long id, Podcast updated) {
        Podcast podcast = getById(id);

        podcast.setTitle(updated.getTitle());
        podcast.setHost(updated.getHost());
        podcast.setDurationMinutes(updated.getDurationMinutes());
        podcast.setReleaseDate(updated.getReleaseDate());

        return podcastRepository.save(podcast);
    }


    public void delete(Long id) {
        podcastRepository.deleteById(id);
    }
}
