package br.senac.tads.dsw.filmes.model;

public record FilmesResponseDTO (Long id, String movieTitle, String movieGenre, Integer movieYear) {
    public FilmesResponseDTO(FilmesModel filmesModel) {
        this(filmesModel.getId(), filmesModel.getMovieTitle(), filmesModel.getMovieGenre(), filmesModel.getMovieYear());
    }
 }