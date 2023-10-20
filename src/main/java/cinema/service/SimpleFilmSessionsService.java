package cinema.service;

import cinema.dto.FilmSessionsDto;
import cinema.model.FilmSessions;
import cinema.model.Films;
import cinema.model.Halls;
import cinema.repository.FilmSessionsRepository;
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
        return
                filmSessionsRepository.findById(id);
    }

    @Override
    public Optional<FilmSessionsDto> findDtoById(int id) {
        Optional<FilmSessions> filmSessions = filmSessionsRepository.findById(id);
        Optional<Halls> hall = hallsService.findById(1);
        Optional<Films> film = filmsService.findById(filmSessions.get().getFilmId());
        return Optional.of(new FilmSessionsDto(filmSessions.get().getId(), film.get().getName(), hall.get().getName(),
                filmSessions.get().getStartTime(), filmSessions.get().getEndTime(), filmSessions.get().getPrice()));
    }

    @Override
    public Collection<FilmSessionsDto> findAll() {
        Collection<FilmSessions> filmSessionsList = filmSessionsRepository.findAll();
        List<FilmSessionsDto> filmSessionsDtoList = new ArrayList<>();
        Halls halls = hallsService.findById(1).get();
        for (FilmSessions filmSessions : filmSessionsList) {
            Optional<Films> films = filmsService.findById(filmSessions.getFilmId());
            filmSessionsDtoList.add(new FilmSessionsDto(filmSessions.getId(), films.get().getName(), halls.getName(),
                    filmSessions.getStartTime(), filmSessions.getEndTime(), filmSessions.getPrice()));
        }
        return filmSessionsDtoList;
    }
}
