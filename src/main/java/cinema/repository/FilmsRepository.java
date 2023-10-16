package cinema.repository;

import cinema.model.Films;
import cinema.model.Users;

import java.util.Collection;
import java.util.Optional;

public interface FilmsRepository {

    Optional<Films> save(Films film);

    Collection<Films> findAll();

    boolean deleteById(int id);

    Optional<Films> findById(int id);
}
