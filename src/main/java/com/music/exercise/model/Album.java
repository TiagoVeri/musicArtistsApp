package com.music.exercise.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//@Entity
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
    private Long id;

    private String name;
    private Integer year;

//    @ManyToMany
    private List<Song> songs;

//    @ManyToMany
    private List<Artist> artists;

    public Album(String name, Integer year) {
        this.name = name;
        this.year = year;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
