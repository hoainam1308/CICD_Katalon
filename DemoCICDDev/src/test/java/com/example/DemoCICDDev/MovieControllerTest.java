package com.example.DemoCICDDev;

import com.example.DemoCICDDev.controller.MovieController;
import com.example.DemoCICDDev.model.Movie;
import com.example.DemoCICDDev.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void testHomePage_ShouldDisplayAllMovies() throws Exception {
        // Chuẩn bị dữ liệu mẫu
        Movie movie1 = new Movie(1L, "Người Nhện", "Jon Watts", "Hành động", 150, "Mô tả phim 1", "url1");
        Movie movie2 = new Movie(2L, "Ma Trận", "Wachowski", "Khoa học viễn tưởng", 140, "Mô tả phim 2", "url2");

        // Thiết lập mock behavior
        when(movieService.getAllMovies()).thenReturn(Arrays.asList(movie1, movie2));

        // Thực thi và kiểm tra
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("movies"))
                .andExpect(content().string(containsString("Người Nhện")))
                .andExpect(content().string(containsString("Ma Trận")));
    }

    @Test
    public void testSearchMovies_ShouldDisplayMatchingMovies() throws Exception {
        // Chuẩn bị dữ liệu mẫu
        Movie movie = new Movie(1L, "Người Nhện", "Jon Watts", "Hành động", 150, "Mô tả phim", "url1");

        // Thiết lập mock behavior
        when(movieService.searchMoviesByTitle("Nhện")).thenReturn(Collections.singletonList(movie));

        // Thực thi và kiểm tra
        mockMvc.perform(get("/search").param("title", "Nhện"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("movies"))
                .andExpect(model().attribute("searchQuery", "Nhện"))
                .andExpect(content().string(containsString("Người Nhện")));
    }

    @Test
    public void testSearchMovies_WhenNoResults_ShouldDisplayNoMoviesMessage() throws Exception {
        // Thiết lập mock behavior
        when(movieService.searchMoviesByTitle("xyz")).thenReturn(Collections.emptyList());

        // Thực thi và kiểm tra
        mockMvc.perform(get("/search").param("title", "xyz"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("movies"))
                .andExpect(model().attribute("searchQuery", "xyz"));
    }
} 