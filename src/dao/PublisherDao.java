package dao;

import entity.PublisherEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublisherDao {

    private static final PublisherDao INSTANCE = new PublisherDao();

    private static final String FIND_ALL = """
                        
            SELECT
            id,
            name,
            created_year
            FROM publishers
                        
            """;

    @SneakyThrows
    public List<PublisherEntity> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL);) {
            var resultSet = preparedStatement.executeQuery();
            List<PublisherEntity> publishers = new ArrayList<>();
            while (resultSet.next()) {
                publishers.add(buildPublisher(resultSet));
            }
            return publishers;
        }
    }

    private PublisherEntity buildPublisher(ResultSet resultSet) throws SQLException {
        return PublisherEntity.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .createdYear(resultSet.getInt("created_year"))
                .build();
    }


    public static PublisherDao getInstance() {
        return INSTANCE;
    }
}
