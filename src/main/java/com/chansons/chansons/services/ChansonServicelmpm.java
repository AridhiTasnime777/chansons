package com.chansons.chansons.services;

import java.util.Date;  // ✅ FIX: was missing — caused "cannot find symbol Date"
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chansons.chansons.entities.Album;
import com.chansons.chansons.entities.Chanson;
import com.chansons.chansons.repositories.AlbumRepository;
import com.chansons.chansons.repositories.ChansonRepository;

@Service
public class ChansonServicelmpm implements ChansonService {

    @Autowired
    ChansonRepository chansonRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Chanson saveChanson(Chanson c) {
        return chansonRepository.save(c);
    }

    @Override
    public Chanson updateChanson(Chanson c) {
        return chansonRepository.save(c);
    }

    @Override
    public void deleteChanson(Chanson c) {
        chansonRepository.delete(c);
    }

    @Override
    public void deleteChansonById(Long id) {
        chansonRepository.deleteById(id);
    }

    @Override
    public Chanson getChanson(Long id) {
        return chansonRepository.findById(id).get();
    }

    @Override
    public List<Chanson> getAllChansons() {
        return chansonRepository.findAll();
    }

    @Override
    public List<Chanson> findByTitle(String title) {
        return chansonRepository.findByTitle(title);
    }

    @Override
    public List<Chanson> findByTitleContains(String title) {
        return chansonRepository.findByTitleContains(title);
    }

    @Override
    public List<Chanson> findByTitleAndDateAfter(String title, Date date) {  // ✅ FIX: Date now imported
        return chansonRepository.findByTitleAndDateAfter(title, date);
    }

    @Override
    public List<Chanson> findByAlbum(Album album) {
        return chansonRepository.findByAlbum(album);
    }

    @Override
    public List<Chanson> findByAlbumIdalb(Long idalb) {
        return chansonRepository.findByAlbumIdalb(idalb);
    }

    @Override  // ✅ FIX: was missing — caused "does not override abstract method" error
    public List<Chanson> findByOrderByTitleAsc() {
        return chansonRepository.findByOrderByTitleAsc();
    }

    @Override
    public List<Chanson> trierChansonsParTitreEtDate() {
        return chansonRepository.trierChansonsParTitreEtDate();
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }
}