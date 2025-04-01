package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Artwork() {
    }

    public Artwork(Long id, String title, String description, Double price, Artist artist) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.artist = artist;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Artist getArtist() { return artist; }
    public void setArtist(Artist artist) { this.artist = artist; }
}
