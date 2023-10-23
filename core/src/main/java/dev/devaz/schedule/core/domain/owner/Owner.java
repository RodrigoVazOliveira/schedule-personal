package dev.devaz.schedule.core.domain.owner;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Model representation for Owner data
 *
 * @param id identify unique owner
 * @param firstName first name of owner
 * @param lastName last name of owner
 * @param dateOfBirth date birth of the owner
 * @param email email of the owner
 * @param dateTimeCreated date and time register new owner
 * @param dateTimeUpdated date and time updated
 */
public record Owner(Long id, String firstName, String lastName, LocalDate dateOfBirth, String email, LocalDateTime dateTimeCreated, LocalDateTime dateTimeUpdated) {
}
