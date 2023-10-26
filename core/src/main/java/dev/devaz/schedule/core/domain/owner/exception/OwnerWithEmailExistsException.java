package dev.devaz.schedule.core.domain.owner.exception;

/**
 * Exception for when exists owner in database with email information by user
 *
 */
public class OwnerWithEmailExistsException extends RuntimeException {
    public OwnerWithEmailExistsException(String message) {
        super(message);
    }
}