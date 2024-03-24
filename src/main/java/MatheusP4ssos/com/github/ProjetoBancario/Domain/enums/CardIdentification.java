package MatheusP4ssos.com.github.ProjetoBancario.Domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@AllArgsConstructor
public enum CardIdentification {

    VISA(0, "VISA CARD"),
    AMERICAN(1, "AMERICAN CARD"),
    CIELO(2, "CIELO CARD"),
    MASTER(3, "MASTER CARD");

    private int cod;
    private String descricao;

    public static CardIdentification toEnum(Integer cod) {
        return EnumSet.allOf(CardIdentification.class).stream()
                .filter(e -> e.getCod() == (cod))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
    }

}