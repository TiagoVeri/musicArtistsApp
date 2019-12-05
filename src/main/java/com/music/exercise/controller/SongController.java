package com.music.exercise.controller;

import com.music.exercise.model.Song;
import com.music.exercise.service.SongService;
import com.music.exercise.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value= "/song")
public class SongController {


    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Song> find(@PathVariable(value = "id") Long Id){
        Song obj = songService.findSongById(Id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Song song){
        song = songService.saveSong(song);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(song.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Song>> findAll(){
        List<Song> list = songService.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable (value = "id") Long id){

        songService.deleteSongById(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@Valid @RequestBody Song song, @PathVariable(value = "id") Long id){
        song.setId(id);
        songService.updateSong(song);

        return ResponseEntity.noContent().build();
    }

}
