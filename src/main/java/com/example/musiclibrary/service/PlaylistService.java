package com.example.musiclibrary.service;

import com.example.musiclibrary.model.Media;
import com.example.musiclibrary.model.Playlist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    private final List<Playlist> playlists = new ArrayList<>();

    public Playlist create(String name) {
        Playlist playlist = new Playlist(name);
        playlists.add(playlist);
        return playlist;
    }

    public List<Playlist> getAll() {
        return playlists;
    }

    public Playlist getById(Long id) {
        return playlists.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
    }

    public void addMedia(Long playlistId, Media media) {
        Playlist playlist = getById(playlistId);
        playlist.addMedia(media);
    }
}
