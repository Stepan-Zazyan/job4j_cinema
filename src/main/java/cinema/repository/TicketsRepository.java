package cinema.repository;

import cinema.model.Halls;
import cinema.model.Tickets;
import cinema.model.Users;

import java.util.Collection;
import java.util.Optional;

public interface TicketsRepository {

    Optional<Tickets> save(Tickets film);

    Collection<Tickets> findAll();

}
