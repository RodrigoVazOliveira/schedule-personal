package dev.devaz.schedule.core.usecase.owner;

import dev.devaz.schedule.core.domain.owner.Owner;

public interface OwnerEntryPointUseCase {

    Owner saveNewOwner(final Owner owner);
    Owner getOwnerById(final Long id);
    Iterable<Owner> getAllOwners();
}
