package dev.devaz.schedule.core.usecase.owner;

import dev.devaz.schedule.core.domain.owner.Owner;

import java.util.Optional;

/**
 * Repository owner for persistence
 *
 */
public interface OwnerRepositoryUseCase {

    /**
     * get all owners
     * @return list owners
     */
    Iterable<Owner> getAll();

    /**
     * save new owner
     *
     * @param owner owner with data for save
     * @return owner with id
     */
    Owner save(final Owner owner);

    /**
     * get owner by id
     * @param id it id for searching
     * @return Optional<Owner>
     */
    Optional<Owner> getById(final Long id);
}
