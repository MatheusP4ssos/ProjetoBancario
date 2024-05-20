package MatheusP4ssos.com.github.ProjetoBancario.Domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonaRequestDto {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

}