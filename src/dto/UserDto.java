package dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {

    private Long id;
    private String name;

}
