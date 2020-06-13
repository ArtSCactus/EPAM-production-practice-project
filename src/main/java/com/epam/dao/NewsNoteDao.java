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
public class NewsNoteDao implements INewsNoteDao {
    @Autowired
    private NewsNotesRepository repository;

    public Optional<NewsNote> fetchById(Long id){
        return repository.findById(id);
    }

    public List<NewsNote> getList(){
        return repository.findAllByOrderByDateDesc();
    }

    public List<NewsNote> getAllSorted(Comparator<NewsNote> comparator){
        List<NewsNote> notes = repository.findAll();
        notes.sort(comparator);
        return notes;
    }

    public NewsNote save(NewsNote note){
       return repository.save(note);
    }

    public void remove(NewsNote note){
        repository.delete(note);
    }

    public void remove(List<Long> idList){
        repository.deleteNewsNotesByIdIn(idList);
    }
}
