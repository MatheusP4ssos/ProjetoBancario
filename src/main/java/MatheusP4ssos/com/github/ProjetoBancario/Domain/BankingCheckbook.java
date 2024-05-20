package MatheusP4ssos.com.github.ProjetoBancario.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankingCheckbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 6, min = 6)
    @Column(unique = true, nullable = false)
    private String number;

    @JsonIgnore
    @Column(name = "checkbook_value")
    private BigDecimal value = new BigDecimal(0);

    private Integer numberOfPages;

    @ManyToOne
    @JoinColumn(name = "currentAccount_id")
    private CurrentAccount currentAccount;

    @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime whenCreated;

}