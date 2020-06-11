package com.epam.dao;

import com.epam.entity.NewsNote;
import com.epam.repository.NewsNotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@Component
public class NewsNoteDao {
    @Autowired
    private NewsNotesRepository repository;

    public Optional<NewsNote> getById(Long id){
        return repository.findById(id);
    }

    public List<NewsNote> getAll(){
        return repository.findAll();
    }

    public List<NewsNote> getAllSorted(Comparator<NewsNote> comparator){
        List<NewsNote> notes = repository.findAll();
        notes.sort(comparator
        );
        return notes;
    }

    public void save(NewsNote note){
        repository.save(note);
    }

    public void remove(NewsNote note){
        repository.delete(note);
    }
}
