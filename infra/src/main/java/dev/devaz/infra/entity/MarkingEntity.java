package dev.devaz.infra.entity;

import dev.devaz.schedule.core.domain.marking.Marking;
import dev.devaz.schedule.core.domain.owner.Owner;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "markings")
public class MarkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE,  CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private OwnerEntity ownerEntity;

    @OneToMany(cascade = {CascadeType.MERGE,  CascadeType.PERSIST}, fetch = FetchType.LAZY)
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

    public MarkingEntity() {
    }

    public MarkingEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(OwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
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

    public Marking convertToMarking() {
        List<Owner> owners = new ArrayList<>();
        invites.forEach(invited -> owners.add(invited.convertToOwner()));

        return new Marking(id, ownerEntity.convertToOwner(), owners, name, description, dateTimeInviteInitial, dateTimeInviteFinal, dateTimeCreated, dateTimeUpdated);
    }

    /**
     * Convert marking to marking entity
     *
     * @param marking marking core
     * @return MarkingEntity
     */
    public static MarkingEntity convertMarkingToMarkingEntity(final Marking marking) {
        final OwnerEntity ownerEntity = OwnerEntity.convertOwnerToOwnerEntity(marking.owner());
        List<OwnerEntity> ownerEntities = new ArrayList<>();
        marking.invites().forEach(owner -> ownerEntities.add(OwnerEntity.convertOwnerToOwnerEntity(owner)));

        MarkingEntity markingEntity = new MarkingEntity();
        markingEntity.setOwnerEntity(ownerEntity);
        markingEntity.setName(marking.name());
        markingEntity.setDescription(marking.description());
        markingEntity.setInvites(ownerEntities);
        markingEntity.setDateTimeInviteInitial(marking.dateTimeInviteInitial());
        markingEntity.setDateTimeInviteFinal(marking.dateTimeInviteFinal());
        markingEntity.setDateTimeCreated(marking.dateTimeCreated());
        markingEntity.setDateTimeUpdated(marking.dateTimeUpdated());


        return markingEntity;
    }
}
