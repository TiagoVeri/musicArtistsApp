package com.music.exercise.service.impl;

import com.music.exercise.model.Artist;
import com.music.exercise.repository.ArtistRepository;
import com.music.exercise.service.ArtistService;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist saveArtist(Artist artist) {
        artist.setId(null);
        return artistRepository.save(artist);
    }
}
