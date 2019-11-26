package com.music.exercise.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//@Entity
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
    private Long id;

    private String name;
    private String nationality;

//    @ManyToMany
    private List<Album> albums;

//    @OneToMany
    private List<Song> songs;


    public Artist() {
    }

    public Artist(Long id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
