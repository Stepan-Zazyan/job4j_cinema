package cinema.service;

import cinema.model.Tickets;

import java.util.Collection;
import java.util.Optional;

public interface TicketsService {

    Optional<Tickets> save(Tickets film);

    Collection<Tickets> findAll();
}
