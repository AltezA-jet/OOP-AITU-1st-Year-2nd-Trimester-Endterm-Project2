package com.example.musiclibrary.service;

import com.example.musiclibrary.cache.SimpleCache;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    
    private final SimpleCache cache = SimpleCache.getInstance();

    
    private static final String SONGS_CACHE_KEY = "songs_all";

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song create(Song song) {
        Song saved = songRepository.save(song);
        cache.remove(SONGS_CACHE_KEY); // инвалидируем кеш
        return saved;
    }

    public List<Song> getAll() {
        
        Object cached = cache.get(SONGS_CACHE_KEY);
        if (cached != null) {
            return (List<Song>) cached;
        }

        
        List<Song> songs = songRepository.findAll();

        
        cache.put(SONGS_CACHE_KEY, songs);

        return songs;
    }

    public Song getById(Long id) {
        return songRepository.findById(id).orElseThrow();
    }

    public Song update(Long id, Song updated) {
        Song song = getById(id);

        song.setTitle(updated.getTitle());
        song.setArtist(updated.getArtist());
        song.setAlbum(updated.getAlbum());
        song.setGenre(updated.getGenre());

        Song saved = songRepository.save(song);

        cache.remove(SONGS_CACHE_KEY); 
        return saved;
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
        cache.remove(SONGS_CACHE_KEY); 
    }
}
