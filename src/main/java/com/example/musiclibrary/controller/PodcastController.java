package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Podcast;
import com.example.musiclibrary.repository.PodcastRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {

    private final PodcastRepository podcastRepository;

    public PodcastController(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    @GetMapping
    public List<Podcast> getAll() {
        return podcastRepository.saveAll(podcastRepository.findAll());
    }

    @PostMapping
    public Podcast create(@RequestBody Podcast podcast) {
        return podcastRepository.save(podcast);
    }
}
