package nu.revitalized.backendtemplate.helpers;

// Imports
import nu.revitalized.backendtemplate.interfaces.IdentifiableUsername;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

public class UriBuilder {
    public static URI buildUriWithUsername(IdentifiableUsername uriObject) {
        return URI.create((
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + uriObject.getUsername()).toUriString())
        );
    }
}
