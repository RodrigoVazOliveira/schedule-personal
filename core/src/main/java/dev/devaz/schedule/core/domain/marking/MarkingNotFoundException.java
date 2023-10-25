package dev.devaz.schedule.core.domain.marking;

public class MarkingNotFoundException extends RuntimeException {
    public MarkingNotFoundException(String message) {
        super(message);
    }
}
