package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.Media;
import com.example.musiclibrary.model.Podcast;
import com.example.musiclibrary.model.Song;

public class MediaFactory {

    public static Media createMedia(String type, String title, String extra) {
        return switch (type.toLowerCase()) {
            case "song" -> new Song(title, extra);      // extra = artist
            case "podcast" -> new Podcast(title, extra); // extra = host
            default -> throw new IllegalArgumentException("Unknown media type");
        };
    }
}
