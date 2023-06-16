package br.senac.tads.dsw.filmes.model;

import br.senac.tads.dsw.filmes.controller.FilmesRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="tb_movie")
@Entity
@Getter //Gera todos métodos de Get da model
@NoArgsConstructor //Recebe um construtor que recebe nenhum argumento
@AllArgsConstructor //Recebe um construtor que recebe todos argumentos
@EqualsAndHashCode(of = "id") //Indica que o id é representação única da model

public class FilmesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieTitle;
    private String movieGenre;
    private Integer movieYear;

    public FilmesModel(FilmesRequestDTO data) {
        this.movieTitle = data.movieTitle();
        this.movieGenre = data.movieGenre();
        this.movieYear = data.movieYear();
    }
}