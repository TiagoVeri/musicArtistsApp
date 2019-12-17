package com.music.exercise.controller;

import com.music.exercise.controller.exception.ResourceReceptionHandler;
import com.music.exercise.model.Artist;
import com.music.exercise.service.ArtistService;
import com.music.exercise.service.exceptions.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value= "/artist")
public class ArtistController {


    private ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Artist> find(@PathVariable(value = "id") Long Id){
        Artist obj = artistService.findArtistById(Id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Artist artist){
        artist = artistService.saveArtist(artist);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(artist.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Artist>> findAll(){
        List<Artist> list = artistService.findAll();
        return  ResponseEntity.ok().body(list);
    }

    //Só deleta artista sem album ou música.
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable(value = "id") Long id){
        artistService.deleteArtistById(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Artist> update(@Valid @RequestBody Artist artist, @PathVariable (value = "id") Long id) throws ObjectNotFoundException {
        artist.setId(id);
        artistService.updateArtist(artist);

        return ResponseEntity.noContent().build();
    }
}
