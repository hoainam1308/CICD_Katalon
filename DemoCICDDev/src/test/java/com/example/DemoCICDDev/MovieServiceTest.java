package com.example.DemoCICDDev;

import com.example.DemoCICDDev.model.Movie;
import com.example.DemoCICDDev.repository.MovieRepository;
import com.example.DemoCICDDev.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchMoviesByTitle_ShouldReturnMatchingMovies() {
        // Chuẩn bị dữ liệu mẫu
        Movie movie1 = new Movie(1L, "Người Nhện", "Jon Watts", "Hành động", 150, "Mô tả phim 1", "url1");
        Movie movie2 = new Movie(2L, "Ma Trận", "Wachowski", "Khoa học viễn tưởng", 140, "Mô tả phim 2", "url2");

        // Thiết lập mock behavior
        when(movieRepository.findByTitleContainingIgnoreCase("Nhện")).thenReturn(Arrays.asList(movie1));
        when(movieRepository.findByTitleContainingIgnoreCase("Ma")).thenReturn(Arrays.asList(movie2));

        // Thực thi kiểm thử
        List<Movie> result1 = movieService.searchMoviesByTitle("Nhện");
        List<Movie> result2 = movieService.searchMoviesByTitle("Ma");

        // Kiểm tra kết quả
        assertEquals(1, result1.size());
        assertEquals("Người Nhện", result1.get(0).getTitle());

        assertEquals(1, result2.size());
        assertEquals("Ma Trận", result2.get(0).getTitle());
    }

    @Test
    public void testGetAllMovies_ShouldReturnAllMovies() {
        // Chuẩn bị dữ liệu mẫu
        Movie movie1 = new Movie(1L, "Người Nhện", "Jon Watts", "Hành động", 150, "Mô tả phim 1", "url1");
        Movie movie2 = new Movie(2L, "Ma Trận", "Wachowski", "Khoa học viễn tưởng", 140, "Mô tả phim 2", "url2");
        Movie movie3 = new Movie(3L, "Bố Già", "Trấn Thành", "Hài, Tình cảm", 128, "Mô tả phim 3", "url3");

        // Thiết lập mock behavior
        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie1, movie2, movie3));

        // Thực thi kiểm thử
        List<Movie> result = movieService.getAllMovies();

        // Kiểm tra kết quả
        assertEquals(3, result.size());
        assertEquals("Người Nhện", result.get(0).getTitle());
        assertEquals("Ma Trận", result.get(1).getTitle());
        assertEquals("Bố Già", result.get(2).getTitle());
    }
} 