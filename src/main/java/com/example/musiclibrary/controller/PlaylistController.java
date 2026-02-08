package com.example.musiclibrary.controller;

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

    // CREATE
    @PostMapping
    public Playlist create(@RequestBody Playlist playlist) {
        return playlistService.create(playlist);
    }

    // READ ALL
    @GetMapping
    public List<Playlist> getAll() {
        return playlistService.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Playlist getById(@PathVariable Long id) {
        return playlistService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Playlist update(@PathVariable Long id, @RequestBody Playlist playlist) {
        return playlistService.update(id, playlist);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playlistService.delete(id);
    }

    // ADD MEDIA
    @PostMapping("/{playlistId}/media/{mediaId}")
    public Playlist addMedia(@PathVariable Long playlistId,
                             @PathVariable Long mediaId) {
        return playlistService.addMedia(playlistId, mediaId);
    }

    // REMOVE MEDIA
    @DeleteMapping("/{playlistId}/media/{mediaId}")
    public Playlist removeMedia(@PathVariable Long playlistId,
                                @PathVariable Long mediaId) {
        return playlistService.removeMedia(playlistId, mediaId);
    }
}
