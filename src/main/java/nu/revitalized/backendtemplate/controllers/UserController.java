package nu.revitalized.backendtemplate.controllers;

// Imports
import jakarta.validation.Valid;
import nu.revitalized.backendtemplate.dtos.input.UserInputDto;
import nu.revitalized.backendtemplate.dtos.output.UserDto;
import nu.revitalized.backendtemplate.exceptions.InvalidInputException;
import nu.revitalized.backendtemplate.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static nu.revitalized.backendtemplate.helpers.BindingResultHelper.handleBindingResultError;
import static nu.revitalized.backendtemplate.helpers.UriBuilder.buildUriWithUsername;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ADMIN -- CRUD Requests
    @GetMapping(value = "")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> dtos = userService.getUsers();

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser(
            @PathVariable("username") String username
    ) {
        UserDto dto = userService.getUser(username);

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<UserDto>> searchUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email
    ) {
        List<UserDto> dtos = userService.getUsersByFilter(username, email);

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @Valid
            @RequestBody UserInputDto inputDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasFieldErrors()) {
            throw new InvalidInputException(handleBindingResultError(bindingResult));
        } else {
            UserDto dto = userService.createUser(inputDto);

            URI uri = buildUriWithUsername(dto);

            return ResponseEntity.created(uri).body(dto);
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(
            @PathVariable("username") String username
    ) {
        String confirmation = userService.deleteUser(username);

        return ResponseEntity.ok().body(confirmation);
    }
}
