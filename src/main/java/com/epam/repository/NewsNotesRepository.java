package com.epam.repository;

import com.epam.entity.NewsNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public interface NewsNotesRepository extends JpaRepository<NewsNote, Long> {
Optional<NewsNote> findById(Long id);

}
