package com.example.DemoCICDDev.service;

import com.example.DemoCICDDev.model.Movie;
import com.example.DemoCICDDev.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
} 