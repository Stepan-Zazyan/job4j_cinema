package cinema.repository;

import cinema.model.FilmSessions;
import cinema.model.Users;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.Optional;

@Repository
public class Sql2oUsersRepository implements UsersRepository {

    private final Sql2o sql2o;

    public Sql2oUsersRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Users> save(Users user) {
        try (var connection = sql2o.open()) {
            var sql = """
                    INSERT INTO users(full_name, email, password)
                    VALUES (:fullName, :email, :password)
                    """;
            var query = connection.createQuery(sql, true)
                    .addParameter("fullName", user.getFullName())
                    .addParameter("email", user.getEmail())
                    .addParameter("password", user.getPassword());
            int generatedId = query.executeUpdate().getKey(Integer.class);
            user.setId(generatedId);
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Users> findByEmailAndPassword(String email, String password) {
        try (Connection connection = sql2o.open()) {
            String sql = "Select * from users where (email = :email and password = :password)";
            Query query = connection.createQuery(sql)
                    .addParameter("email", email)
                    .addParameter("password", password);
            Users user = query.setColumnMappings(Users.COLUMN_MAPPING).executeAndFetchFirst(Users.class);
            return Optional.ofNullable(user);
        }
    }

    @Override
    public boolean deleteById(int id) {
        boolean rsl;
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("DELETE FROM users WHERE id = :id");
            query.addParameter("id", id);
            rsl = query.executeUpdate().getResult() > 0;
        }
        return rsl;
    }

    @Override
    public  Optional<Users> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM users WHERE id = :id");
            query.addParameter("id", id);
            var user = query.setColumnMappings(Users.COLUMN_MAPPING).executeAndFetchFirst(Users.class);
            return Optional.ofNullable(user);
        }
    }

    @Override
    public Collection<Users> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM users");
            return query.setColumnMappings(Users.COLUMN_MAPPING).executeAndFetch(Users.class);
        }
    }
}
