package dev.devaz.infra;

import dev.devaz.schedule.core.domain.marking.Marking;
import dev.devaz.schedule.core.usecase.making.MarkingRepositoryUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class MarkingPersistence implements MarkingRepositoryUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(MarkingPersistence.class);

    @Override
    public Optional<Marking> getMerkingById(Long id) {
        return Optional.empty();
    }

    @Override
    public Boolean existsMarkingById(Long id) {
        return null;
    }

    @Override
    public Marking save(Marking marking) {
        return null;
    }
}
