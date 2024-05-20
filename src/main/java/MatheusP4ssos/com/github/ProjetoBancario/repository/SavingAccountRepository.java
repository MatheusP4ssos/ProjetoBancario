package MatheusP4ssos.com.github.ProjetoBancario.repository;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingAccountRepository extends JpaRepository<SavingAccount, Long> {
}
