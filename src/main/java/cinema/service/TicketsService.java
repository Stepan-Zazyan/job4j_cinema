package cinema.service;

import cinema.model.Tickets;

import java.util.Collection;
import java.util.Optional;

public interface TicketsService {

    Tickets save(Tickets tickets);

    Collection<Tickets> findAll();
}
