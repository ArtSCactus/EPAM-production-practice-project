package com.epam.dao;

import com.epam.entity.NewsNote;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@Component
public interface INewsNoteDao {
    List<NewsNote> getList();
    Optional<NewsNote> fetchById(Long id);
    NewsNote save(NewsNote note);
    void remove(NewsNote note);
}
