package com.example.musiclibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Song extends Media {

    private String artist;
    private String genre;

    @ManyToOne
    private Album album;

    public Song() {}

    public Song(String title, String artist, String genre, Album album) {
        super(title);
        this.artist = artist;
        this.genre = genre;
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
