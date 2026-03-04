package com.chansons.chansons.repositories;

import com.chansons.chansons.entities.Chanson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChansonRepository extends JpaRepository<Chanson, Long> {
    // Add custom query methods if needed
}