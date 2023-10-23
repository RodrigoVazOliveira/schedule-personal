package dev.devaz.schedule.core.usecase.owner;

import dev.devaz.schedule.core.domain.owner.Owner;

/**
 * get a owner by id, if is not found, return an exception
 *
 */
public interface GetOwnerByIdUseCase {

    /**
     * execute search owner by id
     *
     * @param id id of the owner is to searching
     * @return owner return owner founded
     */
    Owner execute(final Long id);
}
