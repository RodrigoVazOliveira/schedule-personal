package dev.devaz.schedule.core.domain.marking;

import dev.devaz.schedule.core.domain.owner.Owner;

import java.time.LocalDateTime;

public record Marking(Long id, Owner owner, Iterable<Owner> invites, String name, String description, LocalDateTime dateTimeInviteInitial, LocalDateTime dateTimeInviteFinal, LocalDateTime dateTimeCreated, LocalDateTime dateTimeUpdated) {

    public final static class Builder {
        private Long id;
        private Owner owner;
        private Iterable<Owner> invites;
        private String name;
        private String description;
        private LocalDateTime dateTimeInviteInitial;
        private LocalDateTime dateTimeInviteFinal;
        private LocalDateTime dateTimeCreated;
        LocalDateTime dateTimeUpdated;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setOwner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public Builder setInvites(Iterable<Owner> invites) {
            this.invites = invites;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDateTimeInviteInitial(LocalDateTime dateTimeInviteInitial) {
            this.dateTimeInviteInitial = dateTimeInviteInitial;
            return this;
        }

        public Builder setDateTimeInviteFinal(LocalDateTime dateTimeInviteFinal) {
            this.dateTimeInviteFinal = dateTimeInviteFinal;
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

        public Marking build() {
            return new Marking(id, owner, invites, name, description, dateTimeInviteInitial, dateTimeInviteFinal, dateTimeCreated, dateTimeUpdated);
        }
    }
}
