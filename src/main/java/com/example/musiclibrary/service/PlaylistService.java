package com.example.musiclibrary.service;

import com.example.musiclibrary.cache.SimpleCache;
import com.example.musiclibrary.model.Media;
import com.example.musiclibrary.model.Playlist;
import com.example.musiclibrary.repository.MediaRepository;
import com.example.musiclibrary.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final MediaRepository mediaRepository;
    private final SimpleCache cache = SimpleCache.getInstance();

    private static final String CACHE_KEY = "playlists_all";

    public PlaylistService(PlaylistRepository playlistRepository,
                           MediaRepository mediaRepository) {
        this.playlistRepository = playlistRepository;
        this.mediaRepository = mediaRepository;
    }

    public Playlist create(Playlist playlist) {
        Playlist saved = playlistRepository.save(playlist);
        cache.remove(CACHE_KEY);
        return saved;
    }

    public List<Playlist> getAll() {
        Object cached = cache.get(CACHE_KEY);
        if (cached != null) {
            return (List<Playlist>) cached;
        }

        List<Playlist> playlists = playlistRepository.findAll();
        cache.put(CACHE_KEY, playlists);
        return playlists;
    }

    public Playlist getById(Long id) {
        return playlistRepository.findById(id).orElseThrow();
    }

    public Playlist update(Long id, Playlist updated) {
        Playlist playlist = getById(id);
        playlist.setName(updated.getName());

        Playlist saved = playlistRepository.save(playlist);
        cache.remove(CACHE_KEY);
        return saved;
    }

    public void delete(Long id) {
        playlistRepository.deleteById(id);
        cache.remove(CACHE_KEY);
    }

    public Playlist addMedia(Long playlistId, Long mediaId) {
        Playlist playlist = getById(playlistId);
        Media media = mediaRepository.findById(mediaId).orElseThrow();

        playlist.getMediaList().add(media);
        Playlist saved = playlistRepository.save(playlist);
        cache.remove(CACHE_KEY);
        return saved;
    }

    public Playlist removeMedia(Long playlistId, Long mediaId) {
        Playlist playlist = getById(playlistId);
        Media media = mediaRepository.findById(mediaId).orElseThrow();

        playlist.getMediaList().remove(media);
        Playlist saved = playlistRepository.save(playlist);
        cache.remove(CACHE_KEY);
        return saved;
    }
}
