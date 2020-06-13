package com.epam.repository;

import com.epam.entity.NewsNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@Repository
@Transactional
public interface NewsNotesRepository extends JpaRepository<NewsNote, Long> {
Optional<NewsNote> findById(Long id);
List<NewsNote> findAllByOrderByDateDesc();
void deleteNewsNotesByIdIn(Iterable<Long> id);

}
