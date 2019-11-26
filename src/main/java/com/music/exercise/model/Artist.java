package com.music.exercise.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private String nationality;

    @ManyToMany
    private List<Album> albums;

    @ManyToMany
    private List<Song> songs;

}
