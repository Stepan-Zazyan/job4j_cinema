package cinema.repository;

import cinema.model.Films;
import cinema.model.Users;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.Optional;

@Repository
public class Sql2oFilmsRepository implements FilmsRepository {

    private final Sql2o sql2o;

    public Sql2oFilmsRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Films> save(Films film) {
        try (var connection = sql2o.open()) {
            var sql = """
                    INSERT INTO films(name, description, "year", genre_id, minimal_age, duration_in_minutes, file_id)
                    VALUES (:name, :description, :year, :genreId, :minimalAge, :durationInMinutes, :fileId)
                    """;
            var query = connection.createQuery(sql, true)
                    .addParameter("name", film.getName())
                    .addParameter("description", film.getDescription())
                    .addParameter("year", film.getYear())
                    .addParameter("genreId", film.getGenreId())
                    .addParameter("minimalAge", film.getMinimalAge())
                    .addParameter("durationInMinutes", film.getDurationInMinutes())
                    .addParameter("fileId", film.getFileId());
            int generatedId = query.executeUpdate().getKey(Integer.class);
            film.setId(generatedId);
            return Optional.of(film);
        }
    }

    @Override
    public boolean deleteById(int id) {
        boolean rsl;
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("DELETE FROM films WHERE id = :id");
            query.addParameter("id", id);
            rsl = query.executeUpdate().getResult() > 0;
        }
        return rsl;
    }

    @Override
    public  Optional<Films> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM films WHERE id = :id");
            query.addParameter("id", id);
            var film = query.setColumnMappings(Films.COLUMN_MAPPING).executeAndFetchFirst(Films.class);
            return Optional.ofNullable(film);
        }
    }

    @Override
    public Collection<Films> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM films");
            return query.setColumnMappings(Films.COLUMN_MAPPING).executeAndFetch(Films.class);
        }
    }
}
