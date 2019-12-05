package com.music.exercise.service.impl;

import com.music.exercise.model.Artist;
import com.music.exercise.repository.ArtistRepository;
import com.music.exercise.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist findArtistById(Long id){
        Optional<Artist> obj = artistRepository.findById(id);

        return obj.orElse(null);
    }

    @Override
    public void deleteArtistById(Long id) {
        Artist obj = findArtistById(id);
        artistRepository.delete(obj);
    }

    @Override
    public Artist updateArtist(Artist artist) {
        Artist oldArtist = findArtistById(artist.getId());
        oldArtist.setName(artist.getName());
        oldArtist.setNationality(artist.getNationality());

        return artistRepository.save(oldArtist);
    }

    @Override
    public Artist saveArtist(Artist artist) {
        artist.setId(null);
        return artistRepository.save(artist);
    }

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }
}
