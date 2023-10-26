package dev.devaz.schedule.core.usecase.making;

import dev.devaz.schedule.core.domain.marking.Marking;
import dev.devaz.schedule.core.domain.owner.Owner;
import dev.devaz.schedule.core.usecase.owner.GetOwnerByIdUseCase;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegisterMarking implements RegisterMarkingUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(RegisterMarking.class);
    private final MarkingRepositoryUseCase markingRepositoryUseCase;
    private final GetOwnerByIdUseCase getOwnerByIdUseCase;

    public RegisterMarking(MarkingRepositoryUseCase markingRepositoryUseCase, GetOwnerByIdUseCase getOwnerByIdUseCase) {
        this.markingRepositoryUseCase = markingRepositoryUseCase;
        this.getOwnerByIdUseCase = getOwnerByIdUseCase;
    }

    @Override
    public Marking execute(Marking marking) {
        LOGGER.info("saving new marking {}", StructuredArguments.keyValue("marking", marking));
        Owner owner = getOwnerByIdUseCase.execute(marking.owner().id());
        List<Owner> invitesDatabase = new ArrayList<>();
        marking.invites().forEach(invited -> invitesDatabase.add(getOwnerByIdUseCase.execute(invited.id())));

        Marking markingSave = new Marking(marking.id(), owner, invitesDatabase, marking.name(), marking.description(), marking.dateTimeInviteInitial(), marking.dateTimeInviteFinal(), LocalDateTime.now(), LocalDateTime.now());
        return markingRepositoryUseCase.save(markingSave);
    }
}
