package dev.devaz.schedule.core.usecase.making;

import dev.devaz.schedule.core.domain.marking.Marking;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterMarking implements RegisterMarkingUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(RegisterMarking.class);
    private final MarkingRepositoryUseCase markingRepositoryUseCase;

    public RegisterMarking(MarkingRepositoryUseCase markingRepositoryUseCase) {
        this.markingRepositoryUseCase = markingRepositoryUseCase;
    }

    @Override
    public Marking execute(Marking marking) {
        LOGGER.info("saving new marking {}", StructuredArguments.keyValue("marking", marking));

        return markingRepositoryUseCase.save(marking);
    }
}
