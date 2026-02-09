package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.*;
import java.time.LocalDate;

public class MediaFactory {

    public static Media createMedia(
            MediaType type,
            String title,
            Artist artist,
            String genre,
            Album album
    ) {
        return switch (type) {
            case SONG -> new Song(title, artist, genre, album);
            case PODCAST -> new Podcast(title, artist.getName(),120,LocalDate.now());
        };
    }
}
