package MatheusP4ssos.com.github.ProjetoBancario.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Extract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String message;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "currentAccount_id")
    private CurrentAccount currentAccount;

    @ManyToOne
    @JoinColumn(name = "savingAccount_id")
    private SavingAccount savingAccount;

    @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime whenCreated;

}