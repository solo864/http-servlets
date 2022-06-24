package service;

import dao.FlightDao;
import dto.FlightDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();

    public List<FlightDto> findAll() {
        return flightDao.findAll()
                .stream().map(flightEntity -> FlightDto.builder()
                        .id(flightEntity.getId())
                        .description("""
                                %s - %s - %s
                                """.formatted(flightEntity.getDepartureAirportCode(), flightEntity.getArrivalAirportCode(), flightEntity.getStatus()))
                        .build()).collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
