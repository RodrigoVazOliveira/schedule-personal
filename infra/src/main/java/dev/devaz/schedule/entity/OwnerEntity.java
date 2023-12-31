package dev.devaz.schedule.entity;

import dev.devaz.schedule.core.domain.owner.Owner;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 *
 * Entity to representation owner in database
 *
 */
@Entity
@Table(name = "owners")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 150)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 150)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "email", length = 450, nullable = false, unique = true)
    private String email;

    @Column(name = "date_time_created", nullable = false)
    private LocalDateTime dateTimeCreated;

    @Column(name = "date_time_updated", nullable = false)
    private LocalDateTime dateTimeUpdated;

    public OwnerEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public LocalDateTime getDateTimeUpdated() {
        return dateTimeUpdated;
    }

    public void setDateTimeUpdated(LocalDateTime dateTimeUpdated) {
        this.dateTimeUpdated = dateTimeUpdated;
    }

    /**
     * convert to owner core
     *
     * @return Owner
     */
    public Owner convertToOwner() {
        return new Owner(id, firstName, lastName, dateOfBirth, email, dateTimeCreated, dateTimeUpdated);
    }

    /**
     * convert owner to onwer entity
     *
     * @param owner owner is converted
     * @return OwnerEntity
     */
    public static OwnerEntity convertOwnerToOwnerEntity(final Owner owner) {
        final OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setFirstName(owner.firstName());
        ownerEntity.setLastName(owner.lastName());
        ownerEntity.setDateOfBirth(owner.dateOfBirth());
        ownerEntity.setEmail(owner.email());
        ownerEntity.setDateTimeCreated(owner.dateTimeCreated());
        ownerEntity.setDateTimeUpdated(owner.dateTimeUpdated());

        return ownerEntity;
    }

}
