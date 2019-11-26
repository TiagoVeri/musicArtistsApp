package com.music.exercise.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//@Entity
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
    private Long id;

    private String name;
    private Integer duration;

//    @ManyToMany
    private List<Artist> artists;

//    @ManyToMany
    private List<Album> albums;

    public Song() {
    }

    public Song(String name, Integer duration) {
        this.name = name;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
