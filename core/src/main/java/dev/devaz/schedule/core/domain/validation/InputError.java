package dev.devaz.schedule.core.domain.validation;

/**
 *
 * class to get input with message for bean validation adapter
 *
 */
public class InputError {
    private final String input;
    private final String message;

    public InputError(String input, String message) {
        this.input = input;
        this.message = message;
    }

    public String getInput() {
        return input;
    }

    public String getMessage() {
        return message;
    }
}
