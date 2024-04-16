package nu.revitalized.backendtemplate.repositories;

// Imports
import nu.revitalized.backendtemplate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    boolean existsByUsernameIgnoreCase(String username);
    boolean existsByEmailIgnoreCase(String email);
}
