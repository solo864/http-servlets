package mapper;

import dto.CreateUserDto;
import entity.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.enums.Gender;
import model.enums.Role;
import util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<UserEntity, CreateUserDto> {



    private static final UserMapper INSTANCE = new UserMapper();

    private static final String IMAGE_FOLDER = "users/";

    public static UserMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public UserEntity MapCreateDtoToEntity(CreateUserDto object) {
        return UserEntity.builder()
                .name(object.getName())
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .image(IMAGE_FOLDER+object.getImage().getSubmittedFileName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .build();
    }
}
