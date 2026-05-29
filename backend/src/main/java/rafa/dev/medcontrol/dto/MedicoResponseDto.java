package rafa.dev.medcontrol.dto;

import java.util.UUID;

public record MedicoResponseDto(UUID id, String nome, String email) {
}
