package com.music.exercise.service;

import com.music.exercise.model.Album;

import java.util.List;

public interface AlbumService {

    Album saveAlbum(final Album album);

    Album findAlbumById(Long id);

    List<Album> findAll();

}