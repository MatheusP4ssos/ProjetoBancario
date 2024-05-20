package MatheusP4ssos.com.github.ProjetoBancario.repository;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawRepository extends JpaRepository<Withdraw, Long> {
}
