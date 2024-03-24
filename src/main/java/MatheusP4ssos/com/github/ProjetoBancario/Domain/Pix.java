package MatheusP4ssos.com.github.ProjetoBancario.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pix_value")
    private BigDecimal value = new BigDecimal(0);

    @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime whenCreated;

    @ManyToOne
    private CurrentAccount destinyAccount;

    @NotNull
    private String destinyKey;

}