package rafa.dev.medcontrol.dto;

import jakarta.validation.constraints.NotBlank;

public record ObservacaoRequestDto(@NotBlank(message = "Descrição da observação é obrigatória") String descricao) {
}
