package rafa.dev.medcontrol.dto;

import jakarta.validation.constraints.NotBlank;


public record MedicoRequestDto(@NotBlank(message = "Nome é obrigatório") String nome,
                               @NotBlank(message = "Email é obrigatório") String email,
                               @NotBlank(message = "Senha é obrigatória") String password) {
}
