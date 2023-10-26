package dev.devaz.schedule.core.domain.owner.entrypoint;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.devaz.schedule.core.domain.owner.Owner;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * Request to entry point
 *
 * @param firstName
 * @param lastName
 * @param dateOfBirth
 * @param email
 */
public record OwnerRequest(

        @NotBlank(message = "firstName deve ser preenchido")
        @Size(message = "tamanho minimo deve ser 3 carateres e no máximo 400", min = 3, max = 400)
        String firstName,

        @NotBlank(message = "lastName deve ser preenchido")
        @Size(message = "tamanho minimo deve ser 3 carateres e no máximo 400", min = 3, max = 400)
        String lastName,

        @NotNull(message = "dateOfBirth deve ser preenchido")
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        LocalDate dateOfBirth,

        @NotBlank(message = "email deve ser preenchido")
        @Email(message = "email informado não é valido")
        @Size(message = "tamanho minimo deve ser 20 carateres e no máximo 450", min = 20, max = 450)
        String email) {

        /**
         * convert to owner
         *
         * @return owner
         */
        public Owner convertToOwner() {
                return new Owner(null, firstName, lastName, dateOfBirth, email, null, null);
        }
}
