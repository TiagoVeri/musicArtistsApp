package com.music.exercise;

import com.music.exercise.model.Album;
import com.music.exercise.model.Artist;
import com.music.exercise.model.Song;
import com.music.exercise.repository.AlbumRepository;
import com.music.exercise.repository.ArtistRepository;
import com.music.exercise.repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private ArtistRepository artistRepository;
	private AlbumRepository albumRepository;
	private SongRepository songRepository;

	public Application(ArtistRepository artistRepository, AlbumRepository albumRepository, SongRepository songRepository) {
		this.artistRepository = artistRepository;
		this.albumRepository = albumRepository;
		this.songRepository = songRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Artist a1 = new Artist(null, "Michael Jackson",  "USA");
		Artist a2 = new Artist(null, "Ray Charles", "USA");

		Album alb1 = new Album(null, "Bad", 1987);
		Album alb2 = new Album(null, "Thriller", 1982);
		Album alb3 = new Album(null, "We Are the World", 1985);

		Song m1 = new Song(null, "Smooth Criminal", 250);
		Song m2 = new Song (null, "Billie Jean", 300);
		Song m3 = new Song (null, "Beat it", 240);
		Song m4 = new Song (null, "We Are the World", 390);

		a1.getAlbums().addAll(Arrays.asList(alb1, alb2, alb3));
		a1.getSongs().addAll(Arrays.asList(m1, m2, m3, m4));
		a2.getAlbums().addAll(Arrays.asList(alb3));
		a2.getSongs().addAll(Arrays.asList(m4));

		alb1.getArtists().addAll(Arrays.asList(a1));
		alb1.getSongs().addAll(Arrays.asList(m1));

		alb2.getArtists().addAll(Arrays.asList(a1));
		alb2.getSongs().addAll(Arrays.asList(m2, m3));

		alb3.getArtists().addAll(Arrays.asList(a1, a2));
		alb3.getSongs().addAll(Arrays.asList(m4));


		m1.getArtists().addAll(Arrays.asList(a1));
		m1.getAlbums().addAll(Arrays.asList(alb1));
		m2.getArtists().addAll(Arrays.asList(a1));
		m2.getAlbums().addAll(Arrays.asList(alb2));

		m3.getArtists().addAll(Arrays.asList(a1));
		m3.getAlbums().addAll(Arrays.asList(alb2));

		m4.getArtists().addAll(Arrays.asList(a1, a2));
		m4.getAlbums().addAll(Arrays.asList(alb3));

		artistRepository.saveAll(Arrays.asList(a1, a2));
		songRepository.saveAll(Arrays.asList(m1, m2, m3, m4));
		albumRepository.saveAll(Arrays.asList(alb1, alb2, alb3));
	}
}
