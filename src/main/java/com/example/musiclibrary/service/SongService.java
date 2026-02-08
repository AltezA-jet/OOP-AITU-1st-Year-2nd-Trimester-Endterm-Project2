package com.example.musiclibrary.service;

import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song create(Song song) {
        return songRepository.save(song);
    }

    public List<Song> getAll() {
        return songRepository.findAll();
    }
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Song getById(Long id) {
        return songRepository.findById(id).orElseThrow();
    }

    public Song update(Long id, Song updated) {
        Song song = getById(id);
        song.setTitle(updated.getTitle());
        song.setArtist(updated.getArtist());
        return songRepository.save(song);
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
    }
}
