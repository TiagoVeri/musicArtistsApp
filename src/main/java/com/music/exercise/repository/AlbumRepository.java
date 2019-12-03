package com.music.exercise.repository;

import com.music.exercise.model.Album;
import com.music.exercise.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {




}
