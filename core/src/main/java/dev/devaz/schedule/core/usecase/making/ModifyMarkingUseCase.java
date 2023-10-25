package dev.devaz.schedule.core.usecase.making;

import dev.devaz.schedule.core.domain.marking.Marking;

/**
 * Modify once marking existences
 *
 */
public interface ModifyMarkingUseCase {

    /**
     * execute modification to marking
     *
     * @param idModifyMarking id marking for is modifying
     * @param marking it is data for modifying
     * @return marking modify
     */
    Marking execute(final Long idModifyMarking, final Marking marking);
}
