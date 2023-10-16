package cinema.repository;

import cinema.model.Genres;
import cinema.model.Halls;
import cinema.model.Users;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.Optional;

@Repository
public class Sql2oHallsRepository implements HallsRepository {

    private final Sql2o sql2o;

    public Sql2oHallsRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Collection<Halls> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM halls");
            return query.setColumnMappings(Halls.COLUMN_MAPPING).executeAndFetch(Halls.class);
        }
    }

    @Override
    public Optional<Halls> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM halls WHERE id = :id");
            query.addParameter("id", id);
            var halls = query.setColumnMappings(Halls.COLUMN_MAPPING).executeAndFetchFirst(Halls.class);
            return Optional.of(halls);
        }
    }

}
