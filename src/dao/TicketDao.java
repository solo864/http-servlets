package dao;

import entity.TicketEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketDao {
    private static final TicketDao INSTANCE = new TicketDao();

    private static final String FIND_ALL_BY_FLIGHT_ID = """
             
                        
            SELECT
            id,
            passenger_no,
            passenger_name,
            seat_no,
            cost
            FROM ticket
            WHERE flight_id = ?
                        
            """;

    @SneakyThrows
    public List<TicketEntity> findAllByFlightId(Long flightId) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_BY_FLIGHT_ID)) {
            preparedStatement.setLong(1, flightId);
            var resultSet = preparedStatement.executeQuery();
            List<TicketEntity> tickets = new ArrayList<>();
            while (resultSet.next()) {
                tickets.add(buildTicket(resultSet));
            }
            return tickets;
        }
    }

    private TicketEntity buildTicket(ResultSet resultSet) throws SQLException {
        return TicketEntity.builder()
                .id(resultSet.getObject("id", Long.class))
                .passengerNo(resultSet.getString("passenger_no"))
                .passengerName(resultSet.getString("passenger_name"))
                .seatNo(resultSet.getString("seat_no"))
                .cost(resultSet.getBigDecimal("cost"))
                .build();
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }
}
