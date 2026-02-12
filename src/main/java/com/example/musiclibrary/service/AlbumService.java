package com.example.musiclibrary.service;

import com.example.musiclibrary.cache.SimpleCache;
import com.example.musiclibrary.model.Album;
import com.example.musiclibrary.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final SimpleCache cache = SimpleCache.getInstance();

    private static final String CACHE_KEY = "albums_all";

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album create(Album album) {
        Album saved = albumRepository.save(album);
        cache.remove(CACHE_KEY);
        return saved;
    }

    public List<Album> getAll() {
        Object cached = cache.get(CACHE_KEY);
        if (cached != null) {
            return (List<Album>) cached;
        }

        List<Album> albums = albumRepository.findAll();
        cache.put(CACHE_KEY, albums);
        return albums;
    }

    public Album getById(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found"));
    }

    public Album update(Long id, Album updated) {
        Album album = getById(id);
        album.setName(updated.getName());
        album.setArtist(updated.getArtist());

        Album saved = albumRepository.save(album);
        cache.remove(CACHE_KEY);
        return saved;
    }

    public void delete(Long id) {
        albumRepository.deleteById(id);
        cache.remove(CACHE_KEY);
    }
}
