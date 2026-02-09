package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Artist;
import com.example.musiclibrary.service.ArtistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public Artist create(@RequestBody Artist artist) {
        return artistService.create(artist);
    }

    @GetMapping
    public List<Artist> getAll() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    public Artist getById(@PathVariable Long id) {
        return artistService.getById(id);
    }

    @PutMapping("/{id}")
    public Artist update(@PathVariable Long id, @RequestBody Artist artist) {
        return artistService.update(id, artist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        artistService.delete(id);
    }
}
