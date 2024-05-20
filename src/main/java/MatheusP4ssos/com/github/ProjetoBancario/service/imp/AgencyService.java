package MatheusP4ssos.com.github.ProjetoBancario.service.imp;

import MatheusP4ssos.com.github.ProjetoBancario.Domain.Agency;
import MatheusP4ssos.com.github.ProjetoBancario.Domain.dto.AgencyRequestDto;
import MatheusP4ssos.com.github.ProjetoBancario.Domain.dto.AgencyResponseDto;
import MatheusP4ssos.com.github.ProjetoBancario.Domain.dto.AgencyUpdateRequestDto;
import MatheusP4ssos.com.github.ProjetoBancario.exception.ObjectNotFoundException;
import MatheusP4ssos.com.github.ProjetoBancario.repository.AgencyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyService implements AgencyServiceInterface {

    private final AgencyRepository agencyRepository;
    private final ObjectMapper mapper;

    @Autowired
    public AgencyService(AgencyRepository agencyRepository, ObjectMapper mapper) {
        this.agencyRepository = agencyRepository;
        this.mapper = mapper;
    }

    @Transactional
    public Agency createAgency(AgencyRequestDto agencyDto) {
        Agency agency = mapper.convertValue(agencyDto, Agency.class);

        return agencyRepository.save(agency);
    }

    public AgencyResponseDto readAgencyById(Long id) {
        Optional<Agency> optionalAgency = agencyRepository.findById(id);

        if (optionalAgency.isEmpty()) {
            throw new ObjectNotFoundException("Agency not found with id: " + id);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        AgencyResponseDto result = objectMapper.convertValue(optionalAgency.get(),
                AgencyResponseDto.class);

        return result;
    }

    public AgencyResponseDto updateAgency(Long id, AgencyUpdateRequestDto dto) {
        Optional<Agency> optionalAgency = agencyRepository.findById(id);

        if (optionalAgency.isEmpty()) {
            throw new ObjectNotFoundException("Agency not found with id: " + id);
        }

        Agency agency = optionalAgency.get();
        agency.setNumber(dto.getNumber());
        agency.setAddress(dto.getAddress());

        Agency savedAgency = agencyRepository.save(agency);

        return mapper.convertValue(savedAgency, AgencyResponseDto.class);
    }
// atualização
    public void deleteAgency(Long id) {
        readAgencyById(id);
        agencyRepository.deleteById(id);
    }

}