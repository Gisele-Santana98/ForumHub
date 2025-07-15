package forumHub.oneProjeto.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicoRequest {
    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Mensagem é obrigatória")
    private String mensagem;
}



