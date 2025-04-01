package com.example.demo.repository;

import com.example.demo.model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {

    // Custom query to find artworks by title
    @Query("SELECT a FROM Artwork a WHERE a.title = :title")
    List<Artwork> findByTitle(@Param("title") String title);

    // Custom query to find artworks cheaper than a given price
    @Query("SELECT a FROM Artwork a WHERE a.price < :price")
    List<Artwork> findArtworksCheaperThan(@Param("price") Double price);

    // Custom query to count artworks by a specific artist
    @Query("SELECT COUNT(a) FROM Artwork a WHERE a.artist.id = :artistId")
    long countArtworksByArtist(@Param("artistId") Long artistId);

    // Delete artwork by title
    @Transactional
    void deleteByTitle(String title);
}
