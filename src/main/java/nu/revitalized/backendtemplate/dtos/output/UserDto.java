package nu.revitalized.backendtemplate.dtos.output;

// Imports
import lombok.Getter;
import lombok.Setter;
import nu.revitalized.backendtemplate.interfaces.IdentifiableUsername;

@Getter
@Setter
public class UserDto implements IdentifiableUsername {
    // Variables
    private String username;
    private String password;
    private String email;
}
