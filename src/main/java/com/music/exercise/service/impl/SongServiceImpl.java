package com.music.exercise.service.impl;

import com.music.exercise.model.Song;
import com.music.exercise.repository.SongRepository;
import com.music.exercise.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song saveSong(Song song) {
        song.setId(null);
        return songRepository.save(song);
    }

    @Override
    public Song findSongById(Long id) {
        Optional<Song> obj = songRepository.findById(id);

        return obj.orElse(null);
    }

    @Override
    public List<Song > findAll() {
        return songRepository.findAll();
    }

    @Override
    public void deleteSongById(Long id)   {
        findSongById(id);

        songRepository.deleteById(id);
    }


}
