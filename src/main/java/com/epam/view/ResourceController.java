package com.epam.view;

import com.epam.dao.NewsNoteDao;
import com.epam.entity.NewsNote;
import com.epam.sort.NewsNoteSortTemplates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@Controller
public class ResourceController {
    @Autowired
    private NewsNoteDao dao;

    @RequestMapping(value = "/fragments", method = RequestMethod.GET)
    public String fragments(Model model) {
        return "fragments/general";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(Model model) {
        List<NewsNote> notes = dao.getAllSorted(byDateComparator());
        model.addAttribute("notes", notes);
        return "index";
    }

    @RequestMapping(value = "/{?}", method = RequestMethod.GET)
    public String viewById(Model model, @PathVariable("?") Long id ){
        Optional<NewsNote> note = dao.getById(id);
        model.addAttribute("note", note.get());
        return "view";
    }

    private Comparator<NewsNote> byDateComparator() {
        return NewsNoteSortTemplates.byDate();
    }
}
