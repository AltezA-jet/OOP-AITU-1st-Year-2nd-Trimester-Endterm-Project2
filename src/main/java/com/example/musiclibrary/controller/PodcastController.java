package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Podcast;
import com.example.musiclibrary.repository.PodcastRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {

    private final PodcastService podcastService;

    public PodcastController(PodcastService podcastService) {
        this.podcastService = podcastService;
    }

    @PostMapping
    public Podcast create(@RequestBody Podcast podcast) {
        return podcastService.create(podcast);
    }

    @GetMapping
    public List<Podcast> getAll() {
        return podcastService.getAll();
    }

    @GetMapping("/{id}")
    public Podcast getById(@PathVariable Long id) {
        return podcastService.getById(id);
    }

    @PutMapping("/{id}")
    public Podcast update(@PathVariable Long id, @RequestBody Podcast podcast) {
        return podcastService.update(id, podcast);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        podcastService.delete(id);
    }
}
