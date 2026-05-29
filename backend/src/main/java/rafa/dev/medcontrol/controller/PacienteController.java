package rafa.dev.medcontrol.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafa.dev.medcontrol.dto.PacienteRequestDto;
import rafa.dev.medcontrol.dto.PacienteResponseDto;
import rafa.dev.medcontrol.service.PacienteService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDto> criar( @Valid @RequestBody PacienteRequestDto dto){
        return ResponseEntity.ok(pacienteService.criar(dto));
    }


    @GetMapping("/me")
    public ResponseEntity<List<PacienteResponseDto>> listar(){
        return ResponseEntity.ok(pacienteService.listarMeusPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDto> buscar(@PathVariable UUID id){
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar( @PathVariable UUID id){
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(("/{id}"))
    public ResponseEntity<PacienteResponseDto> atualizar(@PathVariable UUID id, @RequestBody PacienteRequestDto dto){
        return  ResponseEntity.ok(pacienteService.atualizarPaciente(id, dto));
    }
}
