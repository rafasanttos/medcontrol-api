package rafa.dev.medcontrol.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafa.dev.medcontrol.dto.ObservacaoRequestDto;
import rafa.dev.medcontrol.dto.ObservacaoResponseDto;
import rafa.dev.medcontrol.service.ObservacaoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes/{pacienteId}/observacoes")
public class ObservacaoController {

    private final ObservacaoService observacaoService;

    public ObservacaoController(ObservacaoService observacaoService){
        this.observacaoService = observacaoService;
    }

    @PostMapping()
    public ResponseEntity<ObservacaoResponseDto> criar(@PathVariable UUID pacienteId, @Valid @RequestBody ObservacaoRequestDto dto){
        return ResponseEntity.ok(observacaoService.criar(pacienteId,dto));
    }

    @GetMapping
    public ResponseEntity<List<ObservacaoResponseDto>> listar(@PathVariable UUID pacienteId){
        return ResponseEntity.ok(observacaoService.listarPorPaciente(pacienteId));
    }
}
