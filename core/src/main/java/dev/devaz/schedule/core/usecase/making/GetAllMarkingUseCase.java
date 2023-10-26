package dev.devaz.schedule.core.usecase.making;

import dev.devaz.schedule.core.domain.marking.Marking;

/**
 * get all marking updates
 *
 */
public interface GetAllMarkingUseCase {

    /**
     * get all marking existences
     *
     * @return Iterable<Owner>
     */
    Iterable<Marking> execute();
}
