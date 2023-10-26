package dev.devaz.schedule.entrypoint.marking;

import dev.devaz.schedule.core.domain.marking.Marking;
import dev.devaz.schedule.core.usecase.making.GetAllMarkingUseCase;
import dev.devaz.schedule.core.usecase.making.MarkingEntryPointUseCase;
import dev.devaz.schedule.core.usecase.making.ModifyMarkingUseCase;
import dev.devaz.schedule.core.usecase.making.RegisterMarkingUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MarkingEntryPoint implements MarkingEntryPointUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(MarkingEntryPoint.class);
    private final GetAllMarkingUseCase getAllMarkingUseCase;
    private final ModifyMarkingUseCase modifyMarkingUseCase;
    private final RegisterMarkingUseCase registerMarkingUseCase;

    public MarkingEntryPoint(GetAllMarkingUseCase getAllMarkingUseCase, ModifyMarkingUseCase modifyMarkingUseCase, RegisterMarkingUseCase registerMarkingUseCase) {
        this.getAllMarkingUseCase = getAllMarkingUseCase;
        this.modifyMarkingUseCase = modifyMarkingUseCase;
        this.registerMarkingUseCase = registerMarkingUseCase;
    }

    @Override
    public Marking registerNewMarking(Marking marking) {
        LOGGER.info("register new marking");

        return registerMarkingUseCase.execute(marking);
    }

    @Override
    public Marking modifyMarking(Long idMarking, Marking marking) {
        LOGGER.info("modify marking by id");

        return modifyMarkingUseCase.execute(idMarking, marking);
    }

    @Override
    public Iterable<Marking> getAll() {
        LOGGER.info("get all markings");

        return getAllMarkingUseCase.execute();
    }
}
