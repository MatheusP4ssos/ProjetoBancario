package MatheusP4ssos.com.github.ProjetoBancario.Domain;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.enums.TypeKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @NotNull
    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @OneToMany(mappedBy = "persona")
    private List<CurrentAccount> currentAccounts = new ArrayList<>();

    @OneToMany(mappedBy = "persona")
    private List<SavingAccount> savingAccounts = new ArrayList<>();

    @CPF
    @NotNull
    @Column(unique = true)
    private String cpf;

    private Integer typeKey;

    @Column(length = 1)
    private Character gender;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime lastLogin;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime whenCreated;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDay;

    @ElementCollection
    @CollectionTable(name = "PIX_KEYS")
    private Set<String> pixKeys;

    public TypeKey getTypeKey() {
        return TypeKey.toEnum(this.typeKey);
    }

    public void setTypeKey(TypeKey typeKey) {
        this.typeKey = typeKey.getCod();
    }

    public Persona(String name, String email, String password, String cpf) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
    }
}