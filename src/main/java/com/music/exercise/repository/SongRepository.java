package com.music.exercise.repository;

import com.music.exercise.model.Artist;
import com.music.exercise.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {




}
