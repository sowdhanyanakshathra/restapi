package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Artist;
import com.example.demo.service.ArtistService;
import java.util.List;

@RestController
@RequestMapping("/api/artists")
// @CrossOrigin(origins = "http://localhost:3000")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.getAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        Artist artist = artistService.getArtistById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        Artist newArtist = artistService.createArtist(artist);
        return new ResponseEntity<>(newArtist, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        Artist updatedArtist = artistService.updateArtist(id, artist);
        return new ResponseEntity<>(updatedArtist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Artist>> findByNameContaining(@RequestParam String name) {
        List<Artist> artists = artistService.findByNameContainingIgnoreCase(name);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Artist>> findByGenre(@RequestParam String genre) {
        List<Artist> artists = artistService.findByGenre(genre);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity<List<Artist>> findByLocation(@RequestParam String location) {
        List<Artist> artists = artistService.findByLocation(location);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/top-rated")
    public ResponseEntity<List<Artist>> findTopRatedArtists(@RequestParam double minRating) {
        List<Artist> artists = artistService.findTopRatedArtists(minRating);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Artist>> findByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<Artist> artists = artistService.findByPriceRange(minPrice, maxPrice);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Artist>> findAvailableArtists() {
        List<Artist> artists = artistService.findAvailableArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }
}
