package com.epam.controller;

import com.epam.dao.INewsNoteDao;
import com.epam.dao.NewsNoteDao;
import com.epam.entity.NewsNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ArtSCactus
 * @version 1.1
 */
@Controller
public class NewsNotesActionController {
    @Qualifier("newsNoteDao")
    @Autowired
    private INewsNoteDao dao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainPage(Model model) {
        List<NewsNote> notes = dao.getList();
        model.addAttribute("notes", notes);
        return "index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String viewById(Model model, @PathVariable Long id ){
        Optional<NewsNote> note = dao.fetchById(id);
        model.addAttribute("note", note.get());
        return "view";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteNote(Model model, @PathVariable Long id){
        Optional<NewsNote> note = dao.fetchById(id);
        if (note.isPresent()){
            dao.remove(note.get());
        } else {
            model.addAttribute("error", "not found");
        }
        List<NewsNote> notes = dao.getList();
        model.addAttribute("notes", notes);
        return "index";
    }
    @RequestMapping(value = "/delete-multiple", method = RequestMethod.POST)
    public String deleteMultipleNotes(@RequestParam("delete-mark") List<String> checkboxes){
        List<Long> itemsIdToDelete = new ArrayList<>();
        for (String checkboxValue : checkboxes){
            if (checkboxValue!=null){
                itemsIdToDelete.add(Long.parseLong(checkboxValue));
            }
        }
        ((NewsNoteDao) dao).remove(itemsIdToDelete);
        return "redirect:";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String updateNote(Model model, @ModelAttribute NewsNote note){
        note = dao.save(note);
        model.addAttribute("note", note);
        return "redirect:/"+note.getId();
    }
    @RequestMapping(value = "/edit/{?}", method = RequestMethod.GET)
    public String editPageById(Model model, @PathVariable(name = "?") Long id, @RequestParam String callback){
        Optional<NewsNote> note = dao.fetchById(id);
        model.addAttribute("tab", "Edit news");
        model.addAttribute("note", note.get());
        model.addAttribute("callbackUrl", defineCallbackUrl(id, callback));
        return "create-edit";
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPage(Model model){
        NewsNote note = new NewsNote();
        model.addAttribute("tab", "Add news");
        model.addAttribute("note", note);
        return "create-edit";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String createNews(Model model, @ModelAttribute NewsNote note){
        dao.save(note);
        return "redirect:/view/"+note.getId();
    }

    private String defineCallbackUrl(Long id, String callbackType){
        switch(callbackType){
            case "list":
                return "/";
            case "view":
                return "/"+id;
            default:
                return "";
        }
    }

}
