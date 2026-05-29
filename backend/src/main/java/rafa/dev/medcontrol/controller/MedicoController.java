package rafa.dev.medcontrol.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rafa.dev.medcontrol.dto.MedicoRequestDto;
import rafa.dev.medcontrol.dto.MedicoResponseDto;
import rafa.dev.medcontrol.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @PostMapping()
    public ResponseEntity<MedicoResponseDto> criar(@Valid @RequestBody MedicoRequestDto dto){
        return ResponseEntity.ok(medicoService.criarMedico(dto));
    }
}
