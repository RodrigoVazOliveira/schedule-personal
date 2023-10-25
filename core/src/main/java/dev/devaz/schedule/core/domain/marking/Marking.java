package dev.devaz.schedule.core.domain.marking;

import dev.devaz.schedule.core.domain.owner.Owner;

import java.time.LocalDateTime;

public record Marking(Long id, Owner owner, Iterable<Owner> invites, String name, String description, LocalDateTime dateTimeInviteInitial, LocalDateTime dateTimeInviteFinal, LocalDateTime dateTimeCreated, LocalDateTime dateTimeUpdated) {
}
