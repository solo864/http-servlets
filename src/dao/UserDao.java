package dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import mapper.UserEntity;
import util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao implements Dao<Integer, UserEntity> {

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE = """
                        
            INSERT INTO users (name, email, password, role, gender, birthday) 
            VALUES
            (?, ?, ?, ?, ?, ?)
                        
            """;


    @SneakyThrows
    public UserEntity save(UserEntity entity) {
        try (var connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getEmail());
            preparedStatement.setObject(3, entity.getPassword());
            preparedStatement.setObject(4, entity.getRole().name());
            preparedStatement.setObject(5, entity.getGender().name());
            preparedStatement.setObject(6, entity.getBirthday());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();

            entity.setId(generatedKeys.getInt("id"));
            return entity;
        }
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(UserEntity entity) {

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
