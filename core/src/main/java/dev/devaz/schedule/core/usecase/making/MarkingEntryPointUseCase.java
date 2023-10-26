package dev.devaz.schedule.core.usecase.making;

import dev.devaz.schedule.core.domain.marking.Marking;

/**
 * entrypoint for marking
 *
 */
public interface MarkingEntryPointUseCase {

    /**
     * register new marking in entrypoint
     *
     * @param marking data marking
     * @return Marking new marking
     */
    Marking registerNewMarking(final Marking marking);

    /**
     * update marking by entrypoint
     *
     * @param idMarking id is marking updated
     * @param marking marking updated with data
     * @return Marking with data updated
     */
    Marking modifyMarking(final Long idMarking, final Marking marking);

    /**
     * Get all markings in entrypoint
     *
     * @return Iterable<Marking>
     */
    Iterable<Marking> getAll();
}
