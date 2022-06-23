package service;

import dao.TicketDao;
import entity.TicketEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketService {

    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao =TicketDao.getInstance();

    public List<TicketEntity> findAllByFlightId(Long flightId){
        return ticketDao.findAllByFlightId(flightId);
    }


    public static TicketService getInstance() {
        return INSTANCE;
    }
}
