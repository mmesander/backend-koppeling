package nu.revitalized.backendtemplate.dtos.output;

// Imports
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import nu.revitalized.backendtemplate.interfaces.IdentifiableUsername;
import nu.revitalized.backendtemplate.models.Authority;

import java.util.Set;

@Getter
@Setter
public class UserDto implements IdentifiableUsername {
    // Variables
    private String username;
    private String password;
    private String email;

    // Relations
    @JsonSerialize
    private Set<Authority> authorities;
}
