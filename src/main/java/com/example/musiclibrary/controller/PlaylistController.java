package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Media;
import com.example.musiclibrary.model.Playlist;
import com.example.musiclibrary.service.PlaylistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public Playlist create(@RequestParam String name) {
        return playlistService.create(name);
    }

    @GetMapping
    public List<Playlist> getAll() {
        return playlistService.getAll();
    }

    @PostMapping("/{id}/media")
    public void addMedia(
            @PathVariable Long id,
            @RequestBody Media media
    ) {
        playlistService.addMedia(id, media);
    }
}
