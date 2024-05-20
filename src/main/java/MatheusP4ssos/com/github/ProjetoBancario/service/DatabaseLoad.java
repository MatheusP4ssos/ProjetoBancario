package MatheusP4ssos.com.github.ProjetoBancario.service;


import MatheusP4ssos.com.github.ProjetoBancario.Domain.Agency;
import MatheusP4ssos.com.github.ProjetoBancario.Domain.BankingCheckbook;
import MatheusP4ssos.com.github.ProjetoBancario.Domain.Persona;
import MatheusP4ssos.com.github.ProjetoBancario.repository.AgencyRepository;
import MatheusP4ssos.com.github.ProjetoBancario.repository.BankingCheckbookRepository;
import MatheusP4ssos.com.github.ProjetoBancario.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DatabaseLoad {

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private BankingCheckbookRepository bankingCheckbookRepository;

    public void instantiateDataBaseWithResources() {
        Agency agency = new Agency("Santo Amaro", "0001", "Rua das Flores");

        Persona pessoa = new Persona("Leo", "email@gmail.com", "123456", "17633564776");

        BankingCheckbook checkbook = BankingCheckbook.builder().value(BigDecimal.TEN).whenCreated(
                LocalDateTime.now()).number("154547").numberOfPages(5).build();

        agencyRepository.saveAll(List.of(agency));
        personaRepository.saveAll(List.of(pessoa));
        bankingCheckbookRepository.save(checkbook);

        agencyRepository.deleteById(agency.getId());
    }

}