package br.senac.tads.dsw.filmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //Anota que ela é a classe do SpringBoot, o começo de tudo.
@RestController
public class FilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmesApplication.class, args);
	}
}
