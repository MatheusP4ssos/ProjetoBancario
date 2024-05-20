package MatheusP4ssos.com.github.ProjetoBancario.repository;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
