package MatheusP4ssos.com.github.ProjetoBancario.repository;


import MatheusP4ssos.com.github.ProjetoBancario.Domain.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

}