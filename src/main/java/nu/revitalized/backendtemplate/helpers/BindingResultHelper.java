package nu.revitalized.backendtemplate.helpers;

// Imports
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class BindingResultHelper {
    public static String handleBindingResultError(BindingResult bindingResult) {
        StringBuilder message = new StringBuilder();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            message.append(fieldError.getField());
            message.append(": ");
            message.append(fieldError.getDefaultMessage());
            message.append("\n");
        }

        return message.toString();
    }
}