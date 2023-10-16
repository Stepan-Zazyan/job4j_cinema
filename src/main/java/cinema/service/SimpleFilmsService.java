package cinema.service;

import cinema.dto.FileDto;
import cinema.dto.FilmDto;
import cinema.model.Films;
import cinema.model.Genres;
import cinema.repository.FilmsRepository;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleFilmsService implements FilmsService {

    private final FilmsRepository filmsRepository;

    private final GenresService genresService;

    private final FileService fileService;

    public SimpleFilmsService(FilmsRepository sql2oFilmsRepository, GenresService genresService, FileService fileService) {
        this.filmsRepository = sql2oFilmsRepository;
        this.genresService = genresService;
        this.fileService = fileService;
    }

    @Override
    public Optional<Films> save(Films film, FileDto image) {
        saveNewFile(film, image);
        return filmsRepository.save(film);
    }

    private void saveNewFile(Films film, FileDto image) {
        var file = fileService.save(image);
        film.setFileId(file.getId());
    }

    @Override
    public Optional<Films> findById(int id) {
        return filmsRepository.findById(id);
    }

    @Override
    public boolean deleteById(int id) {
        var fileOptional = findById(id);
        boolean res = false;
        if (fileOptional.isPresent()) {
            res = filmsRepository.deleteById(id);
            fileService.deleteById(fileOptional.get().getFileId());
        }
        return res;
    }

    @Override
    public Collection<FilmDto> findAll() {
        Collection<Films> filmList = filmsRepository.findAll();
        List<FilmDto> filmDtoList = new ArrayList<>();
        for (Films film:  filmList) {
            Genres genre = genresService.findById(film.getGenreId()).get();
            filmDtoList.add(new FilmDto(film.getId(), film.getName(), film.getDescription(),
                    film.getYear(), film.getMinimalAge(), film.getDurationInMinutes(), genre.getName()));
            }
        return filmDtoList;
    }
}
