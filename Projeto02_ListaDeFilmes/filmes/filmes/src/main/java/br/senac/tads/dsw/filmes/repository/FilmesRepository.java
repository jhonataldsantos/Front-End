package br.senac.tads.dsw.filmes.repository;

import br.senac.tads.dsw.filmes.model.FilmesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesRepository extends JpaRepository<FilmesModel, Long> {

}
