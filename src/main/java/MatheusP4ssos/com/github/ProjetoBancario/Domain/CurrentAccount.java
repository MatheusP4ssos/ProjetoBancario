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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccount {

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
    @OneToMany(mappedBy = "currentAccount")
    private List<Extract> extracts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "currentAccount")
    private Set<CreditCard> creditCards = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "currentAccount")
    private Set<Loan> loans = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "currentAccount")
    private List<BankingCheckbook> bankingCheckbooks;

    @JsonIgnore
    @OneToMany(mappedBy = "destinyAccount")
    private List<Pix> receivedPix = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "currentAccount")
    private List<Deposit> deposits = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "currentAccount")
    private List<Withdraw> withdraws = new ArrayList<>();

}