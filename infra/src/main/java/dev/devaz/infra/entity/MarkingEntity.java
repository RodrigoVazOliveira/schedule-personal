package dev.devaz.infra.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "markings")
public class MarkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = {CascadeType.MERGE,  CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private OwnerEntity owner;


    private Iterable<OwnerEntity> invites;

    @Column(nullable = false, length = 400)
    private String name;

    @Column(nullable = false, length = 400)
    private String description;

    @Column(name = "date_time_invite_initial", nullable = false)
    private LocalDateTime dateTimeInviteInitial;

    @Column(name = "date_time_invite_final", nullable = false)
    private LocalDateTime dateTimeInviteFinal;

    @Column(name = "date_time_created", nullable = false)
    private LocalDateTime dateTimeCreated;

    @Column(name = "date_time_updated", nullable = false)
    private LocalDateTime dateTimeUpdated;

    public MarkingEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    public Iterable<OwnerEntity> getInvites() {
        return invites;
    }

    public void setInvites(Iterable<OwnerEntity> invites) {
        this.invites = invites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTimeInviteInitial() {
        return dateTimeInviteInitial;
    }

    public void setDateTimeInviteInitial(LocalDateTime dateTimeInviteInitial) {
        this.dateTimeInviteInitial = dateTimeInviteInitial;
    }

    public LocalDateTime getDateTimeInviteFinal() {
        return dateTimeInviteFinal;
    }

    public void setDateTimeInviteFinal(LocalDateTime dateTimeInviteFinal) {
        this.dateTimeInviteFinal = dateTimeInviteFinal;
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
}
