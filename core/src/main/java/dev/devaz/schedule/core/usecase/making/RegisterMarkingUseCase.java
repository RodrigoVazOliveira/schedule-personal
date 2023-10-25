package dev.devaz.schedule.core.usecase.making;

import dev.devaz.schedule.core.domain.marking.Marking;

/**
 * Saving new marking
 *
 */
public interface RegisterMarkingUseCase {
    /**
     * execute saving new marking
     *
     * @param marking marking data for save
     * @return marking saved with id
     */
    Marking execute(final Marking marking);
}
