package com.music.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    private String name;
    private Integer duration;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name= "ARTIST_SONG",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artists = new ArrayList<>();


    @JsonIgnore
    @ManyToMany(mappedBy = "songs")
    private List<Album> albums = new ArrayList<>();

    public Song() {
    }

    public Song(Long id, String name, Integer duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                '}';
    }
}
