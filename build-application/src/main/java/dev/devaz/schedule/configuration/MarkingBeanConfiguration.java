package dev.devaz.schedule.configuration;

import dev.devaz.schedule.core.usecase.making.MarkingRepositoryUseCase;
import dev.devaz.schedule.core.usecase.making.ModifyMarking;
import dev.devaz.schedule.core.usecase.making.RegisterMarking;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarkingBeanConfiguration {

    @Bean
    ModifyMarking getModifyMarking(MarkingRepositoryUseCase markingRepositoryUseCase) {
        return new ModifyMarking(markingRepositoryUseCase);
    }

    @Bean
    RegisterMarking getRegisterMarking(MarkingRepositoryUseCase markingRepositoryUseCase) {
        return new RegisterMarking(markingRepositoryUseCase);
    }
}