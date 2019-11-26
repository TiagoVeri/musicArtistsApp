package com.music.exercise.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private Integer duration;

    @ManyToMany
    private List<Artist> artists;

    @ManyToMany
    private List<Album> albums;


}
