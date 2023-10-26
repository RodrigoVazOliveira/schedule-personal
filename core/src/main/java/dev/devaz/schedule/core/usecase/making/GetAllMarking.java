package dev.devaz.schedule.core.usecase.making;

import dev.devaz.schedule.core.domain.marking.Marking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAllMarking implements GetAllMarkingUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(GetAllMarking.class);
    private final MarkingRepositoryUseCase markingRepositoryUseCase;

    public GetAllMarking(MarkingRepositoryUseCase markingRepositoryUseCase) {
        this.markingRepositoryUseCase = markingRepositoryUseCase;
    }

    @Override
    public Iterable<Marking> execute() {
        LOGGER.info("Getting all markings");
        return markingRepositoryUseCase.getAll();
    }
}
