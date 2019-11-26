package com.music.exercise.repository;

import com.music.exercise.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository
        extends JpaRepository<Artist, Long>, JpaSpecificationExecutor<Artist> {




}
