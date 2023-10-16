package cinema.repository;

import cinema.model.FilmSessions;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.Optional;

@Repository
public class Sql2oFilmSessionsRepository implements FilmSessionsRepository {
    private final Sql2o sql2o;

    public Sql2oFilmSessionsRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public FilmSessions save(FilmSessions filmSession) {
        try (var connection = sql2o.open()) {
            var sql = """
                    INSERT INTO film_sessions(film_id, halls_id, start_time, end_time, price)
                    VALUES (:filmId, :hallsId, :startTime, :endTime, :price)
                    """;
            var query = connection.createQuery(sql, true)
                    .addParameter("filmId", filmSession.getFilmId())
                    .addParameter("hallsId", filmSession.getHallsId())
                    .addParameter("startTime", filmSession.getStartTime())
                    .addParameter("endTime", filmSession.getEndTime())
                    .addParameter("price", filmSession.getPrice());
            int generatedId = query.executeUpdate().getKey(Integer.class);
            filmSession.setId(generatedId);
            return filmSession;
        }
    }

    @Override
    public boolean deleteById(int id) {
        boolean rsl;
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("DELETE FROM film_sessions WHERE id = :id");
            query.addParameter("id", id);
            rsl = query.executeUpdate().getResult() > 0;
        }
        return rsl;
    }

    @Override
    public Optional<FilmSessions> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM film_sessions WHERE id = :id");
            query.addParameter("id", id);
            var filmSession = query.setColumnMappings(FilmSessions.COLUMN_MAPPING).executeAndFetchFirst(FilmSessions.class);
            return Optional.ofNullable(filmSession);
        }
    }

    @Override
    public Collection<FilmSessions> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM film_sessions");
            return query.setColumnMappings(FilmSessions.COLUMN_MAPPING).executeAndFetch(FilmSessions.class);
        }
    }
}
