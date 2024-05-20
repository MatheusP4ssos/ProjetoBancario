package MatheusP4ssos.com.github.ProjetoBancario.Domain.dto;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.enums.TypeKey;
import lombok.Data;

@Data
public class PersonaResponseDto {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private Integer typeKey;
    private Character gender;

    public TypeKey getTypeKey() {
        return TypeKey.toEnum(this.typeKey);
    }

    public void setTypeKey(TypeKey typeKey) {
        this.typeKey = typeKey.getCod();
    }
}