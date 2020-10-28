package com.mia.bookstore.controller.thymeleaf;

import com.mia.bookstore.model.Genre;
import com.mia.bookstore.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GenreController {
    final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/genres")
    public String showAllGenres(Model model) {

        model.addAttribute("genres", genreService.findAllGenres());
        return "genre/genres";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/creategenre")
    public String createGenre(Model model) {
        model.addAttribute("genre", new Genre());
        return "genre/creategenre";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/creategenre")
    public String createGenre(@ModelAttribute Genre genre) {
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editgenre/{id}")
    public String editGenre(Model model, @PathVariable Long id) {
        Genre genre = genreService.findById(id);
        model.addAttribute("genre", genre);
        return "genre/editgenre";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editgenre/{id}")
    public String editGenre(@ModelAttribute Genre genre, @PathVariable Long id) {

        genreService.saveGenre(genre);
        return "redirect:/genres";

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletegenre/{id}")
    public String deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }
}
