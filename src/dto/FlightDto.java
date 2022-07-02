package dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FlightDto {


    private Long id;
    private String description;

}
