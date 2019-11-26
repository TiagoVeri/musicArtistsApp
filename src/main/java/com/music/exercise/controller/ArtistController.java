package com.music.exercise.controller;

import com.music.exercise.model.Artist;
import com.music.exercise.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "/artist")
public class ArtistController {


    private ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping(method = RequestMethod.POST)

    public ResponseEntity<Void> insert(@Valid @RequestBody Artist artist){
        artist = artistService.saveArtist(artist);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(artist.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }


}
