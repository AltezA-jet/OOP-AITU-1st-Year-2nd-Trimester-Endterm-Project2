package com.example.musiclibrary.model;

import jakarta.persistence.Entity;

@Entity
public class Song extends Media {

    private String artist;

    public Song() {}

    public Song(String title, String artist) {
        super(title);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
