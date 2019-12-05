package com.music.exercise.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    private String name;
    private Integer year;

    @ManyToMany
    @JoinTable(name= "ALBUM_SONG",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> songs = new ArrayList<>();

    @ManyToMany
    @JoinTable(name= "ARTIST_ALBUM",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artists = new ArrayList<>();


    public Album() {
    }

    public Album(Long id, String name, Integer year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }
}
