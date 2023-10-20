package cinema.service;

import cinema.dto.FilmSessionsDto;
import cinema.model.FilmSessions;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface FilmSessionsService {

    FilmSessions save(FilmSessions filmSession);

    boolean deleteById(int id);

    Optional<FilmSessions> findById(int id);

    Optional<FilmSessionsDto> findDtoById(int id);

    Collection<FilmSessionsDto> findAll();
}
