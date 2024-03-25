package repository;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
