package MatheusP4ssos.com.github.ProjetoBancario.Domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AgencyUpdateRequestDto {

    @NotBlank
    @Length(min = 4, max = 4, message = "Please insert 4 numbered digits for the Agency Number")
    private String number;

    @NotBlank
    private String address;

}