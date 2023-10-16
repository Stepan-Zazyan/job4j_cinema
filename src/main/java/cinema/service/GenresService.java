package cinema.service;

import cinema.model.Genres;

import java.util.Collection;
import java.util.Optional;

public interface GenresService {

    Optional<Genres> save(Genres genre);

    Optional<Genres> findById(int id);
    Optional<Genres> findByName(String name);

    Collection<Genres> findAll();
}
