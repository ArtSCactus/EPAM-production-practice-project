package com.epam.view;

import com.epam.dao.NewsNoteDao;
import com.epam.entity.NewsNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@Controller
public class ResourceController {
    @Autowired
    private NewsNoteDao dao;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(Model model) {
        List<NewsNote> notes = dao.getAll();
        model.addAttribute("notes", notes);
        return "index";
    }
}
