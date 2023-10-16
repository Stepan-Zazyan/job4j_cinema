package cinema.service;

import cinema.model.Users;
import cinema.repository.UsersRepository;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleUsersService implements UsersService {
    private final UsersRepository usersRepository;

    SimpleUsersService(UsersRepository sql2oUsersRepository) {
        this.usersRepository = sql2oUsersRepository;
    }

    @Override
    public Optional<Users> save(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public boolean deleteById(int id) {
        return usersRepository.deleteById(id);
    }

    @Override
    public Optional<Users> findById(int id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<Users> findByEmailAndPassword(String email, String password) {
        return usersRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Collection<Users> findAll() {
        return usersRepository.findAll();
    }
}
