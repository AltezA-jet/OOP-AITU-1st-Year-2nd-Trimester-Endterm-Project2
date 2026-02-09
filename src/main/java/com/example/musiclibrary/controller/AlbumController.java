package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Album;
import com.example.musiclibrary.service.AlbumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public Album create(@RequestBody Album album) {
        return albumService.create(album);
    }

    @GetMapping
    public List<Album> getAll() {
        return albumService.getAll();
    }

    @GetMapping("/{id}")
    public Album getById(@PathVariable Long id) {
        return albumService.getById(id);
    }

    @PutMapping("/{id}")
    public Album update(@PathVariable Long id, @RequestBody Album album) {
        return albumService.update(id, album);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        albumService.delete(id);
    }
}
