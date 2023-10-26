package dev.devaz.schedule.core.domain.marking.entrypoint;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.devaz.schedule.core.domain.marking.Marking;
import dev.devaz.schedule.core.domain.owner.Owner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record MarkingRequest(
        @NotNull(message = "campo idOwner do owner deve ser preeenchido")
        Long idOwner,

        @NotNull(message = "campo invites do owner deve ser preeenchido")
        Iterable<Long> invites,

        @NotBlank(message = "name deve ser preenchido")
        @Size(message = "tamanho minimo deve ser 3 carateres e no máximo 400", min = 3, max = 400)
        String name,

        @NotBlank(message = "description deve ser preenchido")
        @Size(message = "tamanho minimo deve ser 3 carateres e no máximo 400", min = 3, max = 400)
        String description,

        @NotNull(message = "campo dateTimeInviteInitial deve ser preeenchido")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime dateTimeInviteInitial,

        @NotNull(message = "campo dateTimeInviteFinal deve ser preeenchido")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime dateTimeInviteFinal) {

    public Marking convertToMarking() {
        List<Owner> invitesConverted = new ArrayList<>();
        invites.forEach(id -> {
            invitesConverted.add(new Owner.Builder().setId(id).build());
        });

        return new Marking.Builder()
                .setOwner(new Owner.Builder().setId(idOwner).build())
                .setInvites(invitesConverted)
                .setName(name)
                .setDescription(description)
                .setDateTimeInviteInitial(dateTimeInviteInitial)
                .setDateTimeInviteFinal(dateTimeInviteFinal)
                .build();
    }
}
