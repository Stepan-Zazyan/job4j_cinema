package cinema.service;

import cinema.dto.FilmSessionsDto;
import cinema.model.FilmSessions;

import java.util.Collection;
import java.util.Optional;

public interface FilmSessionsService {

    FilmSessions save(FilmSessions filmSession);

    boolean deleteById(int id);

    Optional<FilmSessions> findById(int id);

    Collection<FilmSessionsDto> findAll();
}
