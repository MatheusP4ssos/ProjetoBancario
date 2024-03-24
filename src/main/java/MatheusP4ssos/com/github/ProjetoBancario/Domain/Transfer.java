package MatheusP4ssos.com.github.ProjetoBancario.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transfer_value")
    private BigDecimal value = new BigDecimal(0);

    @ManyToOne
    @JoinColumn(name = "currentAccount_id")
    private CurrentAccount destinyAccount;

    @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime whenCreated;

}