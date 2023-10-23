package dev.devaz.schedule.core.domain.marking;

import dev.devaz.schedule.core.domain.owner.Owner;

import java.time.LocalDateTime;
import java.util.Iterator;

public record Marking(Long id, Owner owner, Iterator<Owner> invites, String name, String description, LocalDateTime dateTimeInviteInitial, LocalDateTime dateTimeInviteFinal) {
}
