package com.example.musiclibrary.service;

import com.example.musiclibrary.model.Playlist;
import com.example.musiclibrary.model.Media;
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

    public void addMedia(Playlist playlist, Media media) {
        playlist.addMedia(media);
    }
}
