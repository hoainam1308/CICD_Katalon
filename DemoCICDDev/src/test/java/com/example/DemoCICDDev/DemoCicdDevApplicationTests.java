package com.example.DemoCICDDev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoCicdDevApplicationTests {


	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void homePageShouldContainMovieTicketSystem() {
		String response = this.restTemplate.getForObject(
				"http://localhost:" + port + "/", String.class);
		assertThat(response).contains("Hệ Thống Bán Vé Xem Phim");
		assertThat(response).contains("Tìm kiếm phim");
	}

	@Test
	public void searchPageShouldWorkWithTitle() {
		String response = this.restTemplate.getForObject(
				"http://localhost:" + port + "/search?title=Ma", String.class);
		assertThat(response).contains("Hệ Thống Bán Vé Xem Phim");
		// Kiểm tra xem kết quả tìm kiếm có hoạt động
		assertThat(response).contains("Tìm kiếm phim");
	}
}
