package MatheusP4ssos.com.github.ProjetoBancario.repository;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {
}
