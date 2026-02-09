package com.example.musiclibrary.service;

import com.example.musiclibrary.model.Album;
import com.example.musiclibrary.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album create(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    public Album getById(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found"));
    }

    public Album update(Long id, Album updated) {
        Album album = getById(id);
        album.setName(updated.getName());
        album.setArtist(updated.getArtist());
        return albumRepository.save(album);
    }

    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}
