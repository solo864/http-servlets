package validator;

import dto.CreateUserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.enums.Gender;
import model.enums.Role;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();


    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();
        if (object.getRole() == null || Role.valueOf(object.getRole()) == null) {
            validationResult.add(Error.of("invalid role", "role is invalid"));
        }
        if (object.getGender() == null || Gender.valueOf(object.getGender()) == null) {
            validationResult.add(Error.of("invalid gender", "gender is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
