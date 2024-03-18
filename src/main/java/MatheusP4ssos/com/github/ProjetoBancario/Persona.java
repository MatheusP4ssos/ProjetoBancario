package MatheusP4ssos.com.github.ProjetoBancario;

import MatheusP4ssos.com.github.ProjetoBancario.domain.enums.TypeKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Email
    private String email;

    @JsonIgnore
    private String password;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<SavingAccount> savingAccounts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<CurrentAccount> currentAccounts = new ArrayList<>();

    @CPF
    private String cpf;

    private Integer typeKey;

    @Column(length = 1)
    private Character gender;

    @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime lastLogin;

    @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime whenCreated;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime birthDay;

    @ElementCollection
    @CollectionTable(name = "PIX_KEYS")
    private Set<String> pixKeys;

    public TypeKey getTypeKey() {
        return TypeKey.toEnum(this.typeKey);
    }

    public void setTypeKey(TypeKey typeKey) {
        this.typeKey = typeKey.getCod();
    }

}