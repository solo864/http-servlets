package service;

import dao.UserDao;
import dto.CreateUserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final UserDao userDao = UserDao.getInstance();


    public Integer saveUser(CreateUserDto userDto) {
        //validation
        //mapper
        //save
        return null;
    }


    public static UserService getInstance() {
        return INSTANCE;
    }

}
