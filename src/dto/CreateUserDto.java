package dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {


    private String name;
    private String password;
    private String email;
    private String birthday;
    private String role;
    private String gender;

}
