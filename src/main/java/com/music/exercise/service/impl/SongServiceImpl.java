package com.music.exercise.service.impl;

import com.music.exercise.model.Song;
import com.music.exercise.repository.SongRepository;
import com.music.exercise.service.SongService;
import com.music.exercise.service.exceptions.ObjectNotFoundException;
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

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found - Id: " + id + ", Type: " + Song.class.getName()
        ));
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

    @Override
    public Song updateSong(Song song) {
       Song savedSong = findSongById(song.getId());
       savedSong.setName(song.getName());
       savedSong.setDuration(song.getDuration());

        return songRepository.save(savedSong);
    }


}
