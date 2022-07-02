package mapper;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.enums.Gender;
import model.enums.Role;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {


    private Integer id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthday;
    private Gender gender;
    private Role role;

}
