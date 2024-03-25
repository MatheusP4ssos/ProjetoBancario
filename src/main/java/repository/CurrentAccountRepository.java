package repository;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccountRepository, Long> {
}
