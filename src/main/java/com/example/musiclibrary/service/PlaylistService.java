package com.example.musiclibrary.service;

import com.example.musiclibrary.model.Media;
import com.example.musiclibrary.model.Playlist;
import com.example.musiclibrary.repository.MediaRepository;
import com.example.musiclibrary.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final MediaRepository mediaRepository;

    public PlaylistService(PlaylistRepository playlistRepository,
                           MediaRepository mediaRepository) {
        this.playlistRepository = playlistRepository;
        this.mediaRepository = mediaRepository;
    }

    public Playlist create(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }

    public Playlist getById(Long id) {
        return playlistRepository.findById(id).orElseThrow();
    }

    public Playlist update(Long id, Playlist updated) {
        Playlist playlist = getById(id);
        playlist.setName(updated.getName());
        return playlistRepository.save(playlist);
    }

    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }

    public Playlist addMedia(Long playlistId, Long mediaId) {
        Playlist playlist = getById(playlistId);
        Media media = mediaRepository.findById(mediaId).orElseThrow();
        playlist.getMediaList().add(media);
        return playlistRepository.save(playlist);
    }

    public Playlist removeMedia(Long playlistId, Long mediaId) {
        Playlist playlist = getById(playlistId);
        Media media = mediaRepository.findById(mediaId).orElseThrow();
        playlist.getMediaList().remove(media);
        return playlistRepository.save(playlist);
    }
}
