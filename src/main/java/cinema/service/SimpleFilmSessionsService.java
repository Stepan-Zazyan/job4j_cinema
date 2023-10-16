package cinema.service;

import cinema.dto.FilmDto;
import cinema.dto.FilmSessionsDto;
import cinema.model.FilmSessions;
import cinema.model.Films;
import cinema.model.Genres;
import cinema.model.Halls;
import cinema.repository.FilmSessionsRepository;
import cinema.repository.FilmsRepository;
import cinema.repository.HallsRepository;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleFilmSessionsService implements FilmSessionsService {

    private final FilmSessionsRepository filmSessionsRepository;
    private final HallsService hallsService;
    private final FilmsService filmsService;


    public SimpleFilmSessionsService(FilmSessionsRepository sql2oFilmSessionsRepository, HallsService hallsService, FilmsService filmsService) {
        this.filmSessionsRepository = sql2oFilmSessionsRepository;
        this.hallsService = hallsService;
        this.filmsService = filmsService;
    }


    @Override
    public FilmSessions save(FilmSessions filmSession) {
        return filmSessionsRepository.save(filmSession);
    }

    @Override
    public boolean deleteById(int id) {
        return filmSessionsRepository.deleteById(id);
    }

    @Override
    public Optional<FilmSessions> findById(int id) {
        return filmSessionsRepository.findById(id);
    }

    @Override
    public Collection<FilmSessionsDto> findAll() {
        Collection<FilmSessions> filmSessionsList = filmSessionsRepository.findAll();
        List<FilmSessionsDto> filmSessionsDtoList = new ArrayList<>();
        Halls halls = hallsService.findById(1).get();
        for (FilmSessions filmSessions : filmSessionsList) {
            Films films = filmsService.findById(filmSessions.getFilmId()).get();
            filmSessionsDtoList.add(new FilmSessionsDto(filmSessions.getId(), films.getName(), halls.getName(),
                    filmSessions.getStartTime(), filmSessions.getEndTime(), filmSessions.getPrice()));
        }
        return filmSessionsDtoList;
    }
}
