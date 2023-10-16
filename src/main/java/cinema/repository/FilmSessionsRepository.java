package cinema.repository;

import cinema.model.FilmSessions;

import java.util.Collection;
import java.util.Optional;

public interface FilmSessionsRepository {

    FilmSessions save(FilmSessions filmSession);

    boolean deleteById(int id);

    Optional<FilmSessions> findById(int id);

    Collection<FilmSessions> findAll();
}
