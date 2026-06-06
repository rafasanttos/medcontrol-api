package rafa.dev.medcontrol.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ObservacaoResponseDto(UUID id, String descricao, String nomePaciente, LocalDateTime criadoAt) {
}
