package com.example.demo.repository;

import com.example.demo.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    // Find artists by name (case-insensitive)
    @Query("SELECT a FROM Artist a WHERE a.name ILIKE CONCAT('%', :name, '%')")
List<Artist> findByNameContainingIgnoreCase(@Param("name") String name);

    
    // Find artists by genre
    @Query("SELECT a FROM Artist a WHERE LOWER(a.genre) = LOWER(:genre)")
    List<Artist> findByGenre(@Param("genre") String genre);
    
    // Find artists by location
    @Query("SELECT a FROM Artist a WHERE LOWER(a.location) = LOWER(:location)")
    List<Artist> findByLocation(@Param("location") String location);
    
    // Find top rated artists (assuming there's a rating field)
    @Query("SELECT a FROM Artist a WHERE a.rating >= :minRating ORDER BY a.rating DESC")
    List<Artist> findTopRatedArtists(@Param("minRating") double minRating);
    
    // Find artists by price range
    @Query("SELECT a FROM Artist a WHERE a.pricePerHour BETWEEN :minPrice AND :maxPrice")
    List<Artist> findByPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
    
    // Find available artists
    @Query("SELECT a FROM Artist a WHERE a.isAvailable = true")
    List<Artist> findAvailableArtists();
}