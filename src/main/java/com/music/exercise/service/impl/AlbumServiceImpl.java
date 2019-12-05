package com.music.exercise.service.impl;

import com.music.exercise.model.Album;
import com.music.exercise.model.Artist;
import com.music.exercise.repository.AlbumRepository;
import com.music.exercise.service.AlbumService;
import com.music.exercise.service.exceptions.ObjectNotFoundException;
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

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found - Id: " + id + ", Type: " + Album.class.getName()
        ));
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

    @Override
    public Album updateAlbum(Album album) {
        Album oldAlbum = findAlbumById(album.getId());
        oldAlbum.setName(album.getName());
        oldAlbum.setYear(album.getYear());

        return albumRepository.save(oldAlbum);
    }
}
