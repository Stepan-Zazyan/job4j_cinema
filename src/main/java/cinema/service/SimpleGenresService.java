package cinema.service;

import cinema.model.Genres;
import cinema.repository.GenresRepository;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleGenresService implements GenresService {

    private final GenresRepository genresRepository;

    public SimpleGenresService(GenresRepository sql2oGenresRepository) {
        this.genresRepository = sql2oGenresRepository;
    }

    @Override
    public Optional<Genres> save(Genres genre) {
        return genresRepository.save(genre);
    }

    @Override
    public Optional<Genres> findById(int id) {
        return genresRepository.findById(id);
    }

    @Override
    public Optional<Genres> findByName(String name) {
        return genresRepository.findByName(name);
    }

    @Override
    public Collection<Genres> findAll() {
        return genresRepository.findAll();
    }
}
