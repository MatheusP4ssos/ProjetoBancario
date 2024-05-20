package MatheusP4ssos.com.github.ProjetoBancario.service;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.Persona;
import MatheusP4ssos.com.github.ProjetoBancario.Domain.dto.PersonaRequestDto;
import MatheusP4ssos.com.github.ProjetoBancario.Domain.dto.PersonaResponseDto;
import MatheusP4ssos.com.github.ProjetoBancario.exception.BankObjectNotFoundException;
import MatheusP4ssos.com.github.ProjetoBancario.repository.PersonaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ObjectMapper mapper;

    public Persona createPersona(Persona persona) {
        persona.setId(null);
        persona.setLastLogin(LocalDateTime.now());
        persona.setWhenCreated(LocalDateTime.now());
        Persona savedPersona = personaRepository.save(persona);

        return savedPersona;
    }

    public Persona findPersona(Long id) {
        Optional<Persona> optionalPersona = personaRepository.findById(id);

        return optionalPersona.orElseThrow(
                () -> new BankObjectNotFoundException("Persona Not Found with id: " + id));
    }

    public Set<PersonaResponseDto> findAllPersonas() {
        List<Persona> personaList = personaRepository.findAll();

        return personaList.stream()
                .map(p -> mapper.convertValue(p, PersonaResponseDto.class))
                .collect(Collectors.toSet());
    }

    @Transactional
    public PersonaResponseDto updatePersona(Long id, PersonaRequestDto personaRequestDto) {
        Persona personaFounded = findPersona(id);
        personaFounded.setPassword(personaRequestDto.getPassword());
        personaFounded.setEmail(personaRequestDto.getEmail());

        Persona personaSaved = personaRepository.save(personaFounded);

        return mapper.convertValue(personaSaved, PersonaResponseDto.class);
    }

    @Transactional
    public void deletePersona(Long id) {
        findPersona(id);
        personaRepository.deleteById(id);
    }
}