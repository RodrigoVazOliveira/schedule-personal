package dev.devaz.schedule.entrypoint.owner;

import dev.devaz.schedule.core.domain.owner.Owner;
import dev.devaz.schedule.core.domain.owner.entrypoint.OwnerRequest;
import dev.devaz.schedule.core.domain.owner.exception.OwnerNotFoundException;
import dev.devaz.schedule.core.domain.owner.exception.OwnerWithEmailExistsException;
import dev.devaz.schedule.core.domain.validation.InputError;
import dev.devaz.schedule.core.domain.validation.ResponseError;
import dev.devaz.schedule.core.usecase.owner.OwnerEntryPointUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.logstash.logback.argument.StructuredArguments;
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
@RequestMapping("/v1/owners")
@Validated
public class OwnerRestController {
    private final static Logger LOGGER = LoggerFactory.getLogger(OwnerRestController.class);
    private final OwnerEntryPointUseCase ownerEntryPointUseCase;

    public OwnerRestController(OwnerEntryPointUseCase ownerEntryPointUseCase) {
        this.ownerEntryPointUseCase = ownerEntryPointUseCase;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Owner> saveNewOwner(@Valid @RequestBody OwnerRequest ownerRequest, HttpServletRequest httpServletRequest) throws URISyntaxException {
        LOGGER.info("saving owner. {}", StructuredArguments.keyValue("ownerRequest", ownerRequest));
        final Owner owner = ownerEntryPointUseCase.saveNewOwner(ownerRequest.convertToOwner());
        final String requestURI = httpServletRequest.getRequestURI() + "/" + owner.id();

        return ResponseEntity.created(new URI(requestURI)).body(owner);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Owner> getOwnerById(@NotNull(message = "deve informar o id na path url") @PathVariable final Long id) {
        LOGGER.info("getting owner by id. {}", StructuredArguments.keyValue("id", id));
        final Owner owner = ownerEntryPointUseCase.getOwnerById(id);

        return ResponseEntity.ok(owner);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Iterable<Owner>> getAllOwners() {
        LOGGER.info("get all owners");
        Iterable<Owner> owners = ownerEntryPointUseCase.getAllOwners();

        return ResponseEntity.ok(owners);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    List<InputError> getMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getFieldErrors().stream().map(fieldError -> new InputError(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());
    }

    @ExceptionHandler({OwnerNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseError getOwnerNotFoundException(OwnerNotFoundException ownerNotFoundException) {
        return new ResponseError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), ownerNotFoundException.getMessage());
    }

    @ExceptionHandler({OwnerWithEmailExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseError getOwnerWithEmailExistsException(OwnerWithEmailExistsException ownerWithEmailExistsException) {
        return new ResponseError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), ownerWithEmailExistsException.getMessage());
    }
}
