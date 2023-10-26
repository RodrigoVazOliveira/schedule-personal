package dev.devaz.schedule.core.domain.owner;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Model representation for Owner data
 *
 * @param id              identify unique owner
 * @param firstName       first name of owner
 * @param lastName        last name of owner
 * @param dateOfBirth     date birth of the owner
 * @param email           email of the owner
 * @param dateTimeCreated date and time register new owner
 * @param dateTimeUpdated date and time updated
 */
public record Owner(Long id, String firstName, String lastName, LocalDate dateOfBirth, String email,
                    LocalDateTime dateTimeCreated, LocalDateTime dateTimeUpdated) {

    public final static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String email;
        private LocalDateTime dateTimeCreated;
        private LocalDateTime dateTimeUpdated;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDateTimeCreated(LocalDateTime dateTimeCreated) {
            this.dateTimeCreated = dateTimeCreated;
            return this;
        }

        public Builder setDateTimeUpdated(LocalDateTime dateTimeUpdated) {
            this.dateTimeUpdated = dateTimeUpdated;
            return this;
        }

        public Owner build() {
            return new Owner(id, firstName, lastName, dateOfBirth, email, dateTimeCreated, dateTimeUpdated);
        }
    }
}
