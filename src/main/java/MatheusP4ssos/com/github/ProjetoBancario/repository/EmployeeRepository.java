package repository;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
}
