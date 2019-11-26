package com.music.exercise.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private Integer year;

    @ManyToMany
    private List<Song> songs;

    @ManyToMany
    private List<Artist> artists;


}
