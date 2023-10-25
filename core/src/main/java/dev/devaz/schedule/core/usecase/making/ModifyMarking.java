package dev.devaz.schedule.core.usecase.making;

import dev.devaz.schedule.core.domain.marking.Marking;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class ModifyMarking implements ModifyMarkingUseCase{
    private final static Logger LOGGER = LoggerFactory.getLogger(ModifyMarking.class);
    private final MarkingRepositoryUseCase markingRepositoryUseCase;

    public ModifyMarking(MarkingRepositoryUseCase markingRepositoryUseCase) {
        this.markingRepositoryUseCase = markingRepositoryUseCase;
    }

    @Override
    public Marking execute(Long idModifyMarking, Marking marking) {
        LOGGER.info("modifying marking by id {} {}", StructuredArguments.keyValue("idModifyMarking", idModifyMarking), StructuredArguments.keyValue("marking", marking));
        Boolean existsMarking = markingRepositoryUseCase.existsMarkingById(idModifyMarking);
        if (!existsMarking) {
            LOGGER.warn("not found marking with information id {}", StructuredArguments.keyValue("idModifyMarking", idModifyMarking));

            throw new RuntimeException("not found marking with id " + idModifyMarking);
        }

        Marking markingUpdate = new Marking(idModifyMarking, marking.owner(), marking.invites(), marking.name(), marking.description(), marking.dateTimeInviteInitial(), marking.dateTimeInviteFinal(), null, LocalDateTime.now());
        markingRepositoryUseCase.save(marking);

        return markingUpdate;
    }
}
