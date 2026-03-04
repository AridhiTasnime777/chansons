package com.chansons.chansons.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Chanson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String artist;
    private Date releaseDate;
    public Chanson(String title, String artist, Date releaseDate) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
    }
    public Chanson() {
        
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }  
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String toString() {
        return "Chanson [id=" + id + ", title=" + title + ", artist=" + artist + ", releaseDate=" + releaseDate + "]";
    }

}
