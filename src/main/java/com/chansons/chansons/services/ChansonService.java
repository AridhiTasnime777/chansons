package com.chansons.chansons.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.chansons.chansons.entities.Album;
import com.chansons.chansons.entities.Chanson;

public interface ChansonService {
    Chanson saveChanson(Chanson c);
	Chanson updateChanson(Chanson c);
	void deleteChanson(Chanson c);
	void deleteChansonById(Long id);
	Chanson getChanson(Long id);
	List<Chanson> getAllChansons();
	Page<Chanson> getAllChansonsParPage(int page, int size);
	List<Album> getAllAlbums();
}
