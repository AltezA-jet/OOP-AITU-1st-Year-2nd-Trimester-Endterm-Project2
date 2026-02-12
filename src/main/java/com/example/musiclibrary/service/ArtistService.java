package com.example.musiclibrary.service;

import com.example.musiclibrary.cache.SimpleCache;
import com.example.musiclibrary.model.Artist;
import com.example.musiclibrary.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final SimpleCache cache = SimpleCache.getInstance();

    private static final String CACHE_KEY = "artists_all";

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist create(Artist artist) {
        Artist saved = artistRepository.save(artist);
        cache.remove(CACHE_KEY);
        return saved;
    }

    public List<Artist> getAll() {
        Object cached = cache.get(CACHE_KEY);
        if (cached != null) {
            return (List<Artist>) cached;
        }

        List<Artist> artists = artistRepository.findAll();
        cache.put(CACHE_KEY, artists);
        return artists;
    }

    public Artist getById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    public Artist update(Long id, Artist updated) {
        Artist artist = getById(id);
        artist.setName(updated.getName());

        Artist saved = artistRepository.save(artist);
        cache.remove(CACHE_KEY);
        return saved;
    }

    public void delete(Long id) {
        artistRepository.deleteById(id);
        cache.remove(CACHE_KEY);
    }
}
