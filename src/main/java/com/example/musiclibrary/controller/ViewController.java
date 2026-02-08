package com.example.musiclibrary.controller;

import com.example.musiclibrary.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final SongService songService;

    public ViewController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs-view")
    public String songs(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "songs";
    }
}
