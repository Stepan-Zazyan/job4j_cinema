package cinema.service;

import cinema.model.Users;

import java.util.Collection;
import java.util.Optional;

public interface UsersService {
    Optional<Users> save(Users user);

    Collection<Users> findAll();

    boolean deleteById(int id);

    Optional<Users> findByEmailAndPassword(String email, String password);

    Optional<Users> findById(int id);

}
