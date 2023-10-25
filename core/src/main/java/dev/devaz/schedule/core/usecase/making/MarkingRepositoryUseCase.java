package dev.devaz.schedule.core.usecase.making;

import dev.devaz.schedule.core.domain.marking.Marking;

import java.util.Optional;

/**
 * usecase for repository is the marking
 *
 */
public interface MarkingRepositoryUseCase {

    /**
     * get marking by id
     *
     * @param id id marking for searching
     * @return Optional<Marking>
     */
    Optional<Marking> getMerkingById(final Long id);

    /**
     * verify is exists marking with id information
     *
     * @param id id for checking
     * @return true - case exists or false case not found
     */
    Boolean existsMarkingById(final Long id);

    /**
     * save marking
     * @param marking marking saved or update
     * @return marking with id
     */
    Marking save(final Marking marking);
}
