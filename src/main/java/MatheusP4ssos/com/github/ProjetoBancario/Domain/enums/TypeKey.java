package MatheusP4ssos.com.github.ProjetoBancario.Domain.enums;

import java.util.EnumSet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeKey {

    CPF(0, "CPF"),
    CNPJ(1, "CNPJ"),
    CELLPHONE(2, "CELLPHONE"),
    EMAIL(3, "EMAIL"),
    RANDOM(4, "RANDOM");

    private int cod;
    private String descricao;

    public static TypeKey toEnum(Integer cod) {
        return EnumSet.allOf(TypeKey.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}