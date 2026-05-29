package rafa.dev.medcontrol.dto;

import jakarta.validation.constraints.NotBlank;

public record PacienteRequestDto(@NotBlank(message = "O nome é obrigatório") String nome) {
}
