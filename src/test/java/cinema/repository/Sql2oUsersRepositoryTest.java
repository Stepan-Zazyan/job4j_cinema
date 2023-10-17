package cinema.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import cinema.configuration.DatasourceConfiguration;
import cinema.model.File;
import cinema.model.Users;
import org.sql2o.Sql2oException;

import java.util.Optional;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Sql2oUsersRepositoryTest {

    private static Sql2oUsersRepository sql2oUserRepository;

    private static Sql2oFileRepository sql2oFileRepository;

    private static File file;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oUsersRepositoryTest.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");

        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        var sql2o = configuration.databaseClient(datasource);

        sql2oUserRepository = new Sql2oUsersRepository(sql2o);
        sql2oFileRepository = new Sql2oFileRepository(sql2o);

        file = new File("test", "test");
        sql2oFileRepository.save(file);
    }

    @AfterAll
    public static void deleteFile() {
        sql2oFileRepository.deleteById(file.getId());
    }

    @AfterEach
    public void clearUsers() {
        var users = sql2oUserRepository.findAll();
        for (var user : users) {
            sql2oUserRepository.deleteById(user.getId());
        }
    }

    @Test
    public void whenSaveThenGetSame() {
        var user = sql2oUserRepository.save(new Users(99, "Kolya", "email5", "123"));
        var savedUser = sql2oUserRepository.findByEmailAndPassword("email5", "123");
        assertThat(savedUser).usingRecursiveComparison().isEqualTo(user);
    }

    @Test
    public void whenSaveTheSameEmail() {
        sql2oUserRepository.save(new Users(0, "email9", "Kolya", "123"));
        var savedUser = sql2oUserRepository.save(new Users(1, "email9", "Kolya", "123"));
        assertEquals(savedUser, Optional.empty());
    }

}