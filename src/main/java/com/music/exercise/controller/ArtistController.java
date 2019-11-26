package com.music.exercise.controller;

import com.music.exercise.model.Artist;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "/artist")
public class ArtistController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Artist> getAll(){
        Artist artist1 = new Artist(1L,"Vando", "Brasil");
        Artist artist2 = new Artist(2L, "Guns", "EUA");

        List <Artist> artists = new ArrayList<>();

        artists.add(artist1);
        artists.add(artist2);

        return artists;

    }

}
