package com.example.demo.service;

import com.example.demo.model.Artwork;
import com.example.demo.repository.ArtworkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArtworkService {
    private final ArtworkRepository artworkRepository;

    public ArtworkService(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    public List<Artwork> getAllArtworks() {
        return artworkRepository.findAll();
    }

    public Optional<Artwork> getArtworkById(Long id) {
        return artworkRepository.findById(id);
    }

    public List<Artwork> getArtworkByTitle(String title) {
        return artworkRepository.findByTitle(title);
    }

    public Artwork saveArtwork(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    @Transactional
    public void deleteArtwork(Long id) {
        artworkRepository.deleteById(id);
    }

    @Transactional
    public void deleteArtworkByTitle(String title) {
        artworkRepository.deleteByTitle(title);
    }
}
