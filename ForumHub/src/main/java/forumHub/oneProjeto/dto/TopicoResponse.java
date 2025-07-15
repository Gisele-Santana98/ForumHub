package forumHub.oneProjeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// inclui getters, setters, toString, equals e hashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicoResponse {
    private Long id;
    private String titulo;
    private String nomeAutor;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoResponse(Long id, String titulo, String mensagem, LocalDateTime dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
    }

}
