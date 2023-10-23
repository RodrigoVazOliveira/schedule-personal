package dev.devaz.schedule.core.usecase.owner;

import dev.devaz.schedule.core.domain.owner.Owner;

/**
 * use case for get all owners
 *
 */
public interface GetAllOwnerUseCase {

    /**
     * return all owners
     *
     * @return owners
     */
    Iterable<Owner> execute();
}
