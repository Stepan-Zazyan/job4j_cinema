package cinema.repository;

import cinema.model.Genres;

import java.util.Collection;
import java.util.Optional;

public interface GenresRepository {

    Optional<Genres> save(Genres genre);

    Optional<Genres> findById(int id);

    Optional<Genres> findByName(String name);

    Collection<Genres> findAll();
}
