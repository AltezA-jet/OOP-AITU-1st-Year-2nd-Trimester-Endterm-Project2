package com.example.musiclibrary.service;

import com.example.musiclibrary.model.Artist;
import com.example.musiclibrary.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist create(Artist artist) {
        return artistRepository.save(artist);
    }

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Artist getById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    public Artist update(Long id, Artist updated) {
        Artist artist = getById(id);
        artist.setName(updated.getName());
        return artistRepository.save(artist);
    }

    public void delete(Long id) {
        artistRepository.deleteById(id);
    }
}
