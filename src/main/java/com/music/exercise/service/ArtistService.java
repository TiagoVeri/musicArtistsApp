package com.music.exercise.service;

import com.music.exercise.model.Artist;

import java.util.List;

public interface ArtistService {

    Artist saveArtist(final Artist artist);

    List<Artist> findAll();

    Artist findById (Long id);
}
