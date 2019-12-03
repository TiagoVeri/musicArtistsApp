package com.music.exercise.service;

import com.music.exercise.model.Artist;
import com.music.exercise.model.Song;

import java.util.List;

public interface SongService {

    Song saveSong(final Song song);

    Song findSongById(Long id);

    List <Song> findAll();
}
