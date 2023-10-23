package dev.devaz.schedule.core.usecase.owner;

import dev.devaz.schedule.core.domain.owner.Owner;

/**
 * use case for save new owner
 *
 */
public interface SaveOwnerUseCase {

    /**
     * execute save owner
     *
     * @param owner owner with data saved
     * @return owner
     */
    Owner execute(final Owner owner);
}
