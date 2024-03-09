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
import java.time.LocalDate;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cartao {
    String Numero;
    String Bandeira_Cartao;
    Conta ContaCorrente;
    BigDecimal Limite;
    LocalDate Validade;
    Integer CVV;
    BigDecimal Debito;
    Boolean Credito;
    Boolean CompraOnline;
}
