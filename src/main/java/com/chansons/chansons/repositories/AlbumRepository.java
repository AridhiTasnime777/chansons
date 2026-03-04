package com.chansons.chansons.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chansons.chansons.entities.Album;
public interface AlbumRepository extends JpaRepository<Album, Long> {

}

