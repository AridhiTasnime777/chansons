package com.chansons.chansons.services;
import com.chansons.chansons.repositories.ChansonRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chansons.chansons.entities.Chanson;
@Service
public class ChansonServicelmpm implements ChansonService {

    ChansonRepository chansonRepository;
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
    
}
