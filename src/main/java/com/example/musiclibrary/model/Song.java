package com.example.musiclibrary.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Song extends Media {

    private String genre;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private Album album;

    @ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists;

    public Song() {}

    public Song(String title, Artist artist, String genre, Album album) {
        super(title);
        this.artist = artist;
        this.genre = genre;
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
