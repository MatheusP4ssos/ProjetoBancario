package MatheusP4ssos.com.github.ProjetoBancario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.OverridesAttribute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.List;

import java.math.BigDecimal;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {
    BigDecimal ValorTotal;
    BigDecimal TaxaJuros;
    Integer Parcelas;
    Conta ContaCorrente;
    BigDecimal DebitoRestante;
}