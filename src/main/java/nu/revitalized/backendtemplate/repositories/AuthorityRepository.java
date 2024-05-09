package nu.revitalized.backendtemplate.repositories;

// Imports
import nu.revitalized.backendtemplate.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
    Optional<Authority> findAuthoritiesByAuthorityContainsIgnoreCaseAndUsernameIgnoreCase(String username, String authority);
}
