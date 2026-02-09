package com.example.musiclibrary.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String title;

    @ManyToMany(mappedBy = "mediaList")
    @JsonIgnore
    private List<Playlist> playlists = new ArrayList<>();

    protected Media() {
        // JPA
    }

    protected Media(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
