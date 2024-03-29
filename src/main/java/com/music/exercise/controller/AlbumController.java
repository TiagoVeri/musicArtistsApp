package com.music.exercise.controller;

import com.music.exercise.model.Album;
import com.music.exercise.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {

    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @RequestMapping(value = "/allAlbums", method = RequestMethod.GET)
    public ResponseEntity<List<Album>> findAll (){
        List<Album> albums = albumService.findAll();

        return ResponseEntity.ok().body(albums);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Album album){
        album = albumService.saveAlbum(album);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(album.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Album> findById (@PathVariable (value = "id") Long id){
        Album obj= albumService.findAlbumById(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable (value = "id") Long id){
        albumService.deleteAlbum(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Album> update(@Valid @RequestBody Album album, @PathVariable (value = "id") Long id){
        album.setId(id);
        albumService.updateAlbum(album);

        return ResponseEntity.noContent().build();
    }

}
