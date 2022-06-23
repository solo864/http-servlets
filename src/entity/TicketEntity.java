package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketEntity {

    private Long id;
    private String passengerNo;
    private String passengerName;
    private String seatNo;
    private BigDecimal cost;

}
