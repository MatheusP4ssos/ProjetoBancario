package MatheusP4ssos.com.github.ProjetoBancario.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @NotNull
    private String number;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @JsonIgnore
    private BigDecimal balance = new BigDecimal(BigInteger.ZERO);

    @JsonIgnore
    @OneToMany(mappedBy = "savingAccount")
    private List<Extract> extractList = new ArrayList<>();

}