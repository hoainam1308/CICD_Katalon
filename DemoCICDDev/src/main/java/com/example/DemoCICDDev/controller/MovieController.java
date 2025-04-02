package com.example.DemoCICDDev.controller;

import com.example.DemoCICDDev.model.Movie;
import com.example.DemoCICDDev.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/search")
    public String searchMovies(@RequestParam(required = false) String title, Model model) {
        List<Movie> movies;
        if (title != null && !title.isEmpty()) {
            movies = movieService.searchMoviesByTitle(title);
        } else {
            movies = movieService.getAllMovies();
        }
        model.addAttribute("movies", movies);
        model.addAttribute("searchQuery", title);
        return "index";
    }
} 