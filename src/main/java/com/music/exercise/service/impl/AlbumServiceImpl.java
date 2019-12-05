package com.music.exercise.service.impl;

import com.music.exercise.model.Album;
import com.music.exercise.model.Artist;
import com.music.exercise.repository.AlbumRepository;
import com.music.exercise.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album saveAlbum(Album album) {
        album.setId(null);
        return albumRepository.save(album);
    }

    public Album findAlbumById(Long id){
        Optional<Album> obj = albumRepository.findById(id);

        return obj.orElse(null);
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public void deleteAlbum(Long id) {
      Album album = findAlbumById(id);
      albumRepository.deleteById(id);

    }
}
