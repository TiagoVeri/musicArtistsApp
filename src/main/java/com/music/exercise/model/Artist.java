package com.music.exercise.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artist {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private String nationality;

    @OneToMany
    private List<Album> albuns;

    @OneToMany
    private List<Song> songs;


}
