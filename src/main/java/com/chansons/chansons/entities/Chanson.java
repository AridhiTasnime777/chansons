package com.chansons.chansons.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Chanson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") 
    private Long idChanson; // ✅ FIX: renamed from 'id' to 'idChanson' to match controller/HTML
    private String title;   // ✅ kept as 'title', HTML fixed to match
    private String artist;
    private Date releaseDate;

    @ManyToOne
    private Album album;    // ✅ FIX: added album relationship (referenced in HTML)

    public Chanson(String title, String artist, Date releaseDate) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
    }

    public Chanson() {}

    public Long getIdChanson() { return idChanson; }
    public void setIdChanson(Long idChanson) { this.idChanson = idChanson; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public Date getReleaseDate() { return releaseDate; }
    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public Album getAlbum() { return album; }
    public void setAlbum(Album album) { this.album = album; }

    @Override
    public String toString() {
        return "Chanson [idChanson=" + idChanson + ", title=" + title +
               ", artist=" + artist + ", releaseDate=" + releaseDate + "]";
    }
}