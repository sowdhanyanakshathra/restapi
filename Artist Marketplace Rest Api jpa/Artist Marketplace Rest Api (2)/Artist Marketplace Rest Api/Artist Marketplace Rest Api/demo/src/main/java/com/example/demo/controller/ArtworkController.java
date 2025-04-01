package com.example.demo.controller;

import com.example.demo.model.Artwork;
import com.example.demo.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artworks")
public class ArtworkController {

    @Autowired
    private ArtworkService artworkService;

    // GET all artworks
    @GetMapping
    public List<Artwork> getAllArtworks() {
        return artworkService.getAllArtworks();
    }

    // GET artwork by ID
    @GetMapping("/{id}")
    public Optional<Artwork> getArtworkById(@PathVariable Long id) {
        return artworkService.getArtworkById(id);
    }

    // GET artwork by title (Custom Query)
    @GetMapping("/title/{title}")
    public List<Artwork> getArtworkByTitle(@PathVariable String title) {
        return artworkService.getArtworkByTitle(title);
    }

    // CREATE artwork
    @PostMapping
    public Artwork createArtwork(@RequestBody Artwork artwork) {
        return artworkService.saveArtwork(artwork);
    }

    // UPDATE artwork
    @PutMapping("/{id}")
    public Artwork updateArtwork(@PathVariable Long id, @RequestBody Artwork updatedArtwork) {
        Optional<Artwork> existingArtwork = artworkService.getArtworkById(id);
        if (existingArtwork.isPresent()) {
            Artwork artwork = existingArtwork.get();
            artwork.setTitle(updatedArtwork.getTitle());
            artwork.setDescription(updatedArtwork.getDescription());
            artwork.setPrice(updatedArtwork.getPrice());
            artwork.setArtist(updatedArtwork.getArtist());
            return artworkService.saveArtwork(artwork);
        }
        return null; // or throw a custom exception
    }

    // DELETE artwork by ID
    @DeleteMapping("/{id}")
    public void deleteArtwork(@PathVariable Long id) {
        artworkService.deleteArtwork(id);
    }

    // DELETE artwork by title (Custom Query)
    @DeleteMapping("/deleteByTitle")
    public void deleteArtworkByTitle(@RequestParam String title) {
        artworkService.deleteArtworkByTitle(title);
    }
}
