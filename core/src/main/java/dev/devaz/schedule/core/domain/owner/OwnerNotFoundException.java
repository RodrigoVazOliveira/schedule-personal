package dev.devaz.schedule.core.domain.owner;

/**
 * exception when not found owner
 *
 */
public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException(String message) {
        super(message);
    }
}
