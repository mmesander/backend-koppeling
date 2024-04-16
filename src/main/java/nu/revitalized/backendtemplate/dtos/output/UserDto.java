package nu.revitalized.backendtemplate.dtos.output;

// Imports
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    // Variables
    private String username;
    private String password;
    private String email;
}
