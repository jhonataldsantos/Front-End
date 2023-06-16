package br.senac.tads.dsw.filmes.controller;

import br.senac.tads.dsw.filmes.model.FilmesModel;
import br.senac.tads.dsw.filmes.model.FilmesResponseDTO;
import br.senac.tads.dsw.filmes.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Tá dizendo pro Spring que é o Controller da aplicação.
@RequestMapping("movie") //Indicamos o endpoint (que é basicamente uma URL, uma localização
                            // digital exposta pela API a partir da API que recebe e responde as consultas.)

public class FilmesController {

    @Autowired
    private FilmesRepository filmesRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveMovie(@RequestBody FilmesRequestDTO data) {
        FilmesModel filmesModel = new FilmesModel(data);
        filmesRepository.save(filmesModel);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FilmesResponseDTO> getAll() {
        List<FilmesResponseDTO> movieList = filmesRepository.findAll().stream().map(FilmesResponseDTO::new).toList();
        return movieList;
    }
}