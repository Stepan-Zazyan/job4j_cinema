package cinema.repository;

import cinema.model.Users;

import java.util.Collection;
import java.util.Optional;

public interface UsersRepository {
    Optional<Users> save(Users user);

    Optional<Users> findByEmailAndPassword(String email, String password);

    Collection<Users> findAll();

    boolean deleteById(int id);

    Optional<Users> findById(int id);

}
