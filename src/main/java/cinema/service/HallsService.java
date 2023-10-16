package cinema.service;

import cinema.model.Halls;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface HallsService {

    Collection<Halls> findAll();

    Optional<Halls> findById(int id);
}
