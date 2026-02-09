package com.example.musiclibrary.model;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Podcast extends Media {

    private String host;
    private int durationMinutes;
    private LocalDate releaseDate;

    protected Podcast() {
        // JPA
    }

    public Podcast(
            String title,
            String host,
            int durationMinutes,
            LocalDate releaseDate
    ) {
        super(title);
        this.host = host;
        this.durationMinutes = durationMinutes;
        this.releaseDate = releaseDate;
    }

    public String getHost() {
        return host;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
