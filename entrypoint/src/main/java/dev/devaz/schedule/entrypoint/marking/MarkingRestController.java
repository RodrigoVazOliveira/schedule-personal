package dev.devaz.schedule.entrypoint.marking;

import dev.devaz.schedule.core.domain.marking.Marking;
import dev.devaz.schedule.core.domain.marking.entrypoint.MarkingRequest;
import dev.devaz.schedule.core.domain.marking.exception.MarkingNotFoundException;
import dev.devaz.schedule.core.domain.owner.exception.OwnerWithEmailExistsException;
import dev.devaz.schedule.core.domain.validation.InputError;
import dev.devaz.schedule.core.domain.validation.ResponseError;
import dev.devaz.schedule.core.usecase.making.MarkingEntryPointUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/markings")
@Validated
@Tag(name = "Controle de marcação de reunião", description = "Gerencia o controle marcação")
class MarkingRestController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MarkingRestController.class);
    private final MarkingEntryPointUseCase markingEntryPointUseCase;

    public MarkingRestController(MarkingEntryPointUseCase markingEntryPointUseCase) {
        this.markingEntryPointUseCase = markingEntryPointUseCase;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(description = "Cadastrar uma nova marcação", summary = "Cadastrar uma nova marcação")
    ResponseEntity<Marking> save(@Valid @RequestBody MarkingRequest markingRequest, HttpServletRequest httpServletRequest) throws URISyntaxException {
        LOGGER.info("save new marking");
        Marking marking = markingRequest.convertToMarking();
        final Marking markingSaved = markingEntryPointUseCase.registerNewMarking(marking);
        String responseURI = httpServletRequest.getRequestURI() + "/" + markingSaved.id();

        return ResponseEntity.created(new URI(responseURI)).body(markingSaved);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(description = "Obtem todas as marcaçòes", summary = "Obtem todas as marcaçòes")
    ResponseEntity<Iterable<Marking>> getAll() {
        LOGGER.info("get all marking");
        Iterable<Marking> markings = markingEntryPointUseCase.getAll();

        return ResponseEntity.ok(markings);
    }

    @PatchMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(description = "Atualizar uma marcação por id", summary = "Atualizar uma marcação por id")
    ResponseEntity<Marking> updatePartialMarking(@NotNull(message = "id deve ser informado") @PathVariable("id") Long idMarking, @Valid @RequestBody MarkingRequest markingRequest) {
        LOGGER.info("updating partial marking");
        final Marking marking = markingRequest.convertToMarking();
        Marking markingUpdated = markingEntryPointUseCase.modifyMarking(idMarking, marking);

        return ResponseEntity.ok(markingUpdated);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    List<InputError> getMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getFieldErrors().stream().map(fieldError -> new InputError(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());
    }

    @ExceptionHandler({MarkingNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseError getOwnerWithEmailExistsException(OwnerWithEmailExistsException ownerWithEmailExistsException) {
        return new ResponseError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), ownerWithEmailExistsException.getMessage());
    }
}
