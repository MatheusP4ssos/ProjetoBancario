package MatheusP4ssos.com.github.ProjetoBancario.Domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public abstract class Account {

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @NotNull
    private String number;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona customers;

    private BigDecimal balance = new BigDecimal(BigInteger.ZERO);

    private List<Extract> extractList = new ArrayList<>();

}
