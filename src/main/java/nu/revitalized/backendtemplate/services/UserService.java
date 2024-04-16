package nu.revitalized.backendtemplate.services;

// Imports
import lombok.Getter;
import lombok.Setter;
import nu.revitalized.backendtemplate.dtos.input.UserInputDto;
import nu.revitalized.backendtemplate.dtos.output.UserDto;
import nu.revitalized.backendtemplate.models.User;
import nu.revitalized.backendtemplate.repositories.UserRepository;

import java.util.List;

import static nu.revitalized.backendtemplate.helpers.CopyProperties.copyProperties;

@Getter
@Setter
public class UserService {
    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    // Transfer Methods
    public User dtoToUser(UserInputDto inputDto) {
        User user = new User();

        user.setUsername(inputDto.getUsername().toLowerCase());
        user.setPassword(inputDto.getPassword());
        user.setEmail(inputDto.getEmail());

        return user;
    }

    public UserDto userToDto(User user) {
        UserDto userDto = new UserDto();

        copyProperties(user, userDto);

        return userDto;
    }

    // CRUD Methods
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto>
    }
}
