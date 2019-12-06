package com.music.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    private String name;
    private String nationality;

    @JsonIgnore
    @ManyToMany(mappedBy = "artists")
    private List<Album> albums = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "artists")
    private List<Song> songs = new ArrayList<>();

    public Artist() {
    }

    public Artist(Long id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                '}';
    }
}
