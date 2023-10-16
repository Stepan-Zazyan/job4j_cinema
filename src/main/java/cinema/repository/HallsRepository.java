package cinema.repository;

import cinema.model.Genres;
import cinema.model.Halls;

import java.util.Collection;
import java.util.Optional;

public interface HallsRepository {

    Collection<Halls> findAll();

    Optional<Halls> findById(int id);

}
