package MatheusP4ssos.com.github.ProjetoBancario.repository;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
