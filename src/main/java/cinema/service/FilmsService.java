package cinema.service;

import cinema.dto.FileDto;
import cinema.dto.FilmDto;
import cinema.model.Films;

import java.util.Collection;
import java.util.Optional;

public interface FilmsService {

    Optional<Films> save(Films film, FileDto image);

    Optional<Films> findById(int id);

    boolean deleteById(int id);

    Collection<FilmDto> findAll();
}
