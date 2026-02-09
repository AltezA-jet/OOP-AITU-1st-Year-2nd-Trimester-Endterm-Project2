package com.example.musiclibrary.model;

import jakarta.persistence.*;

@Entity
public class Song extends Media {

    @ManyToOne
    private Artist artist;

    private String genre;

    @ManyToOne
    private Album album;

    protected Song() {
        // JPA
    }

    public Song(String title, Artist artist, String genre, Album album) {
        super(title);
        this.artist = artist;
        this.genre = genre;
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public Album getAlbum() {
        return album;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
