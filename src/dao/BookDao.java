package dao;

import entity.BookEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDao {

    private static final BookDao INSTANCE = new BookDao();

    private static final String FIND_ALL = """
                        
            SELECT
            id,
            name,
            genre,
            page_count,
            publishing_year
            FROM books
                        
            """;

    private static final String SAVE = """
                    
            INSERT INTO books (name, genre, page_count, publishing_year)
            VALUES (?, ?, ?, ?)
                    
            """;
    private static final String FIND_BY_PUBLISHER_ID = FIND_ALL + " WHERE publisher_id = ?";

    @SneakyThrows
    public BookEntity save(BookEntity bookEntity) {
        try (var connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, bookEntity.getName());
            preparedStatement.setString(2, bookEntity.getGenre());
            preparedStatement.setInt(3, bookEntity.getPageCount());
            preparedStatement.setInt(4, bookEntity.getPublishingYear());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                bookEntity.setId(generatedKeys.getLong("id"));
            }
            return bookEntity;
        }
    }

    @SneakyThrows
    public List<BookEntity> findByPublisherId(Long publisherId) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_PUBLISHER_ID)) {
            preparedStatement.setLong(1, publisherId);
            var resultSet = preparedStatement.executeQuery();
            List<BookEntity> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(BookEntity.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .genre(resultSet.getString("genre"))
                        .pageCount(resultSet.getInt("page_count"))
                        .publishingYear(resultSet.getInt("publishing_year"))
                        .build());
            }
            return books;
        }
    }

    public static BookDao getInstance() {
        return INSTANCE;
    }


}
