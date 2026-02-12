package com.example.musiclibrary.service;

import com.example.musiclibrary.cache.SimpleCache;
import com.example.musiclibrary.model.Podcast;
import com.example.musiclibrary.repository.PodcastRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodcastService {

    private final PodcastRepository podcastRepository;
    private final SimpleCache cache = SimpleCache.getInstance();

    private static final String CACHE_KEY = "podcasts_all";

    public PodcastService(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    public Podcast create(Podcast podcast) {
        Podcast saved = podcastRepository.save(podcast);
        cache.remove(CACHE_KEY);
        return saved;
    }

    public List<Podcast> getAll() {
        Object cached = cache.get(CACHE_KEY);
        if (cached != null) {
            return (List<Podcast>) cached;
        }

        List<Podcast> podcasts = podcastRepository.findAll();
        cache.put(CACHE_KEY, podcasts);
        return podcasts;
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

        Podcast saved = podcastRepository.save(podcast);
        cache.remove(CACHE_KEY);
        return saved;
    }

    public void delete(Long id) {
        podcastRepository.deleteById(id);
        cache.remove(CACHE_KEY);
    }
}
