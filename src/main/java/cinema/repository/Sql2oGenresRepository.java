package cinema.repository;

import cinema.model.Genres;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.Optional;

@Repository
public class Sql2oGenresRepository implements GenresRepository {
    private final Sql2o sql2o;

    public Sql2oGenresRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public Optional<Genres> save(Genres genre) {
        try (var connection = sql2o.open()) {
            var sql = """
                    INSERT INTO genres(name)
                    VALUES (:name)
                    """;
            var query = connection.createQuery(sql, true)
                    .addParameter("name", genre.getName());
            int generatedId = query.executeUpdate().getKey(Integer.class);
            genre.setId(generatedId);
            return Optional.of(genre);
        }
    }

    @Override
    public Optional<Genres> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM genres WHERE id = :id");
            query.addParameter("id", id);
            var genre = query.executeAndFetchFirst(Genres.class);
            return Optional.of(genre);
        }
    }

    @Override
    public Optional<Genres> findByName(String name) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM genres WHERE name = :name");
            query.addParameter("name", name);
            var genre = query.executeAndFetchFirst(Genres.class);
            return Optional.of(genre);
        }
    }

    @Override
    public Collection<Genres> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM genres");
            return query.executeAndFetch(Genres.class);
        }
    }
}
