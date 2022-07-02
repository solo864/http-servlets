package mapper;

import dto.CreateUserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.enums.Gender;
import model.enums.Role;
import util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserMapper implements Mapper<UserEntity, CreateUserDto> {



    private static final CreateUserMapper INSTANCE = new CreateUserMapper();


    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public UserEntity mapTo(CreateUserDto object) {
        return UserEntity.builder()
                .name(object.getName())
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .birthday(LocalDateFormatter.format(object.getBirthday()))

                .build();
    }
}
