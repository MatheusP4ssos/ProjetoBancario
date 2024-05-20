package MatheusP4ssos.com.github.ProjetoBancario.controller;


import MatheusP4ssos.com.github.ProjetoBancario.Domain.Agency;
import MatheusP4ssos.com.github.ProjetoBancario.Domain.dto.AgencyRequestDto;
import MatheusP4ssos.com.github.ProjetoBancario.Domain.dto.AgencyResponseDto;
import MatheusP4ssos.com.github.ProjetoBancario.Domain.dto.AgencyUpdateRequestDto;
import MatheusP4ssos.com.github.ProjetoBancario.service.imp.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/agencies")
public class AgencyController {

    private final AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> createAgency(@RequestBody AgencyRequestDto agencyDto) {
        Agency savedAgency = null;

        savedAgency = agencyService.createAgency(agencyDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedAgency.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AgencyResponseDto> readAgencyById(@PathVariable Long id) {
        return ResponseEntity.ok(agencyService.readAgencyById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AgencyResponseDto> updateAgency(@PathVariable Long id,
                                                          @RequestBody AgencyUpdateRequestDto agencyUpdateRequestDto) {
        return ResponseEntity.ok(agencyService.updateAgency(id, agencyUpdateRequestDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable Long id) {
        agencyService.deleteAgency(id);
        return ResponseEntity.noContent().build();
    }

}