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


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ContaCorrente extends Conta {
    List <Emprestimo> emprestimoList;
    List <Cartao> cartaoList;
    List <Cheque> chequeList;


}
