package com.example.DemoCICDDev.config;

import com.example.DemoCICDDev.model.Movie;
import com.example.DemoCICDDev.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Autowired
    public DataInitializer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) {
        // Khởi tạo dữ liệu mẫu nếu không có dữ liệu trong hệ thống
        if (movieRepository.count() == 0) {
            List<Movie> movies = Arrays.asList(
                new Movie(null, "Người Nhện: Không còn nhà", "Jon Watts", "Hành động, Phiêu lưu", 148, 
                    "Peter Parker phải đối mặt với các vấn đề khi danh tính của anh bị tiết lộ.", 
                    "https://m.media-amazon.com/images/M/MV5BZWMyYzFjYTYtNTRjYi00OGExLWE2YzgtOGRmYjAxZTU3NzBiXkEyXkFqcGdeQXVyMzQ0MzA0NTM@._V1_.jpg"),
                    
                new Movie(null, "Ma Trận: Hồi sinh", "Lana Wachowski", "Khoa học viễn tưởng, Hành động", 148, 
                    "Neo phải lựa chọn theo viên thuốc đỏ hoặc xanh và quay trở lại Ma Trận.", 
                    "https://upload.wikimedia.org/wikipedia/vi/5/50/The_Matrix_Resurrections.jpg"),
                    
                new Movie(null, "Đội Quân Cảm Tử", "James Gunn", "Hành động, Phiêu lưu", 132, 
                    "Amanda Waller tập hợp các siêu ác nhân cho nhiệm vụ nguy hiểm.", 
                    "https://m.media-amazon.com/images/M/MV5BNGM3YzdlOWYtNjViZS00MTE2LWE1MWUtZmE2ZTcxZjcyMmU3XkEyXkFqcGdeQXVyODEyMTI1MjA@._V1_.jpg"),
                    
                new Movie(null, "Tenet", "Christopher Nolan", "Khoa học viễn tưởng, Hành động", 150, 
                    "Một điệp viên được tuyển dụng vào một tổ chức bí ẩn gọi là Tenet để tham gia vào một nhiệm vụ toàn cầu.", 
                    "https://m.media-amazon.com/images/M/MV5BYzg0NGM2NjAtNmIxOC00MDJmLTg5ZmYtYzM0MTE4NWE2NzlhXkEyXkFqcGdeQXVyMTA4NjE0NjEy._V1_.jpg"),
                    
                new Movie(null, "Anh Trai Yêu Quái", "Vũ Ngọc Đãng", "Hài, Gia đình", 120, 
                    "Câu chuyện về ba anh em sống trong một gia đình đầy biến cố.", 
                    "https://upload.wikimedia.org/wikipedia/vi/f/fe/Anh_Trai_Y%C3%AAu_Qu%C3%A1i_poster.jpg"),
                    
                new Movie(null, "Bố Già", "Trấn Thành", "Hài, Tình cảm", 128, 
                    "Câu chuyện về tình cảm gia đình giữa một người cha và cậu con trai.", 
                    "https://upload.wikimedia.org/wikipedia/vi/thumb/5/59/B%E1%BB%91_Gi%C3%A0_poster.jpg/440px-B%E1%BB%91_Gi%C3%A0_poster.jpg")
            );
            
            movieRepository.saveAll(movies);
        }
    }
} 