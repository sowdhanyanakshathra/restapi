package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.model.Artist;
import com.example.demo.repository.ArtistRepository;
import java.util.List;


@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist not found with id: " + id));
    }

    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist updateArtist(Long id, Artist updatedArtist) {
        return artistRepository.findById(id).map(artist -> {
            artist.setName(updatedArtist.getName());
            artist.setBio(updatedArtist.getBio());
            artist.setEmail(updatedArtist.getEmail());
            artist.setArtworks(updatedArtist.getArtworks());
            return artistRepository.save(artist);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist not found with id: " + id));
    }

    public void deleteArtist(Long id) {
        if (!artistRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist not found with id: " + id);
        }
        artistRepository.deleteById(id);
    }

    public List<Artist> findByNameContainingIgnoreCase(String name) {
        return artistRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Artist> findByGenre(String genre) {
        return artistRepository.findByGenre(genre);
    }

    public List<Artist> findByLocation(String location) {
        return artistRepository.findByLocation(location);
    }

    public List<Artist> findTopRatedArtists(double minRating) {
        return artistRepository.findTopRatedArtists(minRating);
    }

    public List<Artist> findByPriceRange(double minPrice, double maxPrice) {
        return artistRepository.findByPriceRange(minPrice, maxPrice);
    }

    public List<Artist> findAvailableArtists() {
        return artistRepository.findAvailableArtists();
    }
}
