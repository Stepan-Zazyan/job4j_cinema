package cinema.service;

import cinema.model.Halls;
import cinema.repository.HallsRepository;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleHallsService implements HallsService {

    private final HallsRepository hallsRepository;

    SimpleHallsService(HallsRepository sql2oHallsRepository) {
        this.hallsRepository = sql2oHallsRepository;
    }

    @Override
    public Collection<Halls> findAll() {
        return hallsRepository.findAll();
    }

    @Override
    public Optional<Halls> findById(int id) {
        return hallsRepository.findById(id);
    }
}
