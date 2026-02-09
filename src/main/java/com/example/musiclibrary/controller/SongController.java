package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public Song create(@RequestBody Song song) {
        return songService.create(song);
    }

    @GetMapping
    public List<Song> getAll() {
        return songService.getAll();
    }

    @GetMapping("/{id}")
    public Song getById(@PathVariable Long id) {
        return songService.getById(id);
    }

    @PutMapping("/{id}")
    public Song update(@PathVariable Long id, @RequestBody Song song) {
        return songService.update(id, song);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        songService.delete(id);
    }
}
