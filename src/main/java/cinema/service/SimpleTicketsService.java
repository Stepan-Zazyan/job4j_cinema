package cinema.service;

import cinema.model.Tickets;
import cinema.repository.TicketsRepository;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleTicketsService implements  TicketsService {

    private final TicketsRepository ticketsRepository;

    SimpleTicketsService(TicketsRepository sql2oTicketsRepository) {
        this.ticketsRepository = sql2oTicketsRepository;
    }

    @Override
    public Optional<Tickets> save(Tickets ticket) {
        return ticketsRepository.save(ticket);
    }

    @Override
    public Collection<Tickets> findAll() {
        return ticketsRepository.findAll();
    }
}
