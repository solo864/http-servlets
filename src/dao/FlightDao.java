package dao;

import entity.FlightEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import model.enums.FlightStatus;
import util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlightDao {


    private static final FlightDao INSTANCE = new FlightDao();


    private static final String FIND_ALL_SQL = """
             
                        
            SELECT
            id,
            flight_no,
            departure_date,
            departure_airport_code,
            arrival_date,
            arrival_airport_code,
            status
            FROM flight
                        
            """;

    @SneakyThrows
    public List<FlightEntity> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<FlightEntity> flights = new ArrayList<>();
            while (resultSet.next()) {
                flights.add(buildFlight(resultSet));
            }
            return flights;
        }
    }

    private FlightEntity buildFlight(ResultSet resultSet) throws SQLException {
        return FlightEntity.builder()
                .id(resultSet.getObject("id", Long.class))
                .flightNo(resultSet.getObject("flight_no", String.class))
                .departureDate(resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime())
                .departureAirportCode(resultSet.getObject("departure_airport_code", String.class))
                .arrivalDate(resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime())
                .arrivalAirportCode(resultSet.getObject("arrival_airport_code", String.class))
                .status(FlightStatus.valueOf(resultSet.getObject("status", String.class)))
                .build();
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }

}
