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
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private  Long id;
    private List<Persona> clientes;
    private String endereco;
    private String numero;
    private List <funcionarios> funcionariosList;
    private List <ContaCorrente> contaCorrenteList ;
    private List <ContaPoupanca> contaPoupancaList;



}
