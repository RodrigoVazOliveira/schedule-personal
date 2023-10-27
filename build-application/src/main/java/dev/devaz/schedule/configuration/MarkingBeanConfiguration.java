package dev.devaz.schedule.configuration;

import dev.devaz.schedule.core.usecase.making.GetAllMarking;
import dev.devaz.schedule.core.usecase.making.MarkingRepositoryUseCase;
import dev.devaz.schedule.core.usecase.making.ModifyMarking;
import dev.devaz.schedule.core.usecase.making.RegisterMarking;
import dev.devaz.schedule.core.usecase.owner.GetOwnerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MarkingBeanConfiguration {

    @Bean
    ModifyMarking getModifyMarking(MarkingRepositoryUseCase markingRepositoryUseCase) {
        return new ModifyMarking(markingRepositoryUseCase);
    }

    @Bean
    RegisterMarking getRegisterMarking(MarkingRepositoryUseCase markingRepositoryUseCase, GetOwnerByIdUseCase getOwnerByIdUseCase) {
        return new RegisterMarking(markingRepositoryUseCase, getOwnerByIdUseCase);
    }

    @Bean
    GetAllMarking getAllMarking(MarkingRepositoryUseCase markingRepositoryUseCase) {
        return new GetAllMarking(markingRepositoryUseCase);
    }
}