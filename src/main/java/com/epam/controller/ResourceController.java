package com.epam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ArtSCactus
 * @version 1.1
 */
@Controller
public class ResourceController {

    @RequestMapping(value = "/fragments", method = RequestMethod.GET)
    public String fragments(Model model) {
        return "fragments/general";
    }
}
