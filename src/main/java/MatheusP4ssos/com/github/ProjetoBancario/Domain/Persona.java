package domain;

import MatheusP4ssos.com.github.ProjetoBancario.enums.TypeKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

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
    private String email;

    @JsonIgnore
    private String password;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<CurrentAccount> currentAccounts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<SavingAccount> savingAccounts = new ArrayList<>();

    @CPF
    @NotNull
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

    @JsonFormat(pattern = "dd/MM/yyyy ")
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