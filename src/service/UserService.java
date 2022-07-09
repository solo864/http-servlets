package service;

import dao.UserDao;
import dto.CreateUserDto;
import entity.UserEntity;
import exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import mapper.UserMapper;
import validator.CreateUserValidator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();


    private final CreateUserValidator userValidator = getInstance().userValidator;
    ;
    private final UserMapper userMapper = UserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();
    private final UserDao userDao = UserDao.getInstance();


    @SneakyThrows
    public void saveUser(CreateUserDto userDto) {
        var validationResult = userValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        final UserEntity userEntity = userMapper.MapCreateDtoToEntity(userDto);
        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        userDao.save(userEntity);
    }


    public static UserService getInstance() {
        return INSTANCE;
    }

}
