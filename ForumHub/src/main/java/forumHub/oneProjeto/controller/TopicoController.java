package forumHub.oneProjeto.controller;

import forumHub.oneProjeto.dto.TopicoResponse;
import forumHub.oneProjeto.model.Topico;
import forumHub.oneProjeto.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // Criar
    @PostMapping
    public ResponseEntity<Topico> criar(@RequestBody @Valid Topico topico) {
        Topico novo = topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // Listar todos
    @GetMapping
    public List<Topico> listar() {
        return topicoRepository.findAll();
    }

    // Buscar por ID
    @GetMapping("/topicos/{id}")
    public ResponseEntity<TopicoResponse> buscarPorId(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(t -> new TopicoResponse(t.getId(), t.getTitulo(), t.getMensagem(), t.getDataCriacao()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Atualizar
    @PutMapping("/topicos/{id}")
    public ResponseEntity<?> atualizarTopico(@PathVariable Long id, @RequestBody Topico topicoAtualizado) {
        Optional<Topico> existente = topicoRepository.findById(id);

        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico não encontrado");
        }

        Topico topico = existente.get();
        topico.setTitulo(topicoAtualizado.getTitulo());
        topico.setMensagem(topicoAtualizado.getMensagem());
        // atualize outros campos se houver

        topicoRepository.save(topico);

        return ResponseEntity.ok("Tópico atualizado com sucesso");
    }

    // Deletar
    @DeleteMapping("/topicos/{id}")
    public ResponseEntity<?> deletarTopico(@PathVariable Long id) {
        if (!topicoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico não encontrado");
        }

        topicoRepository.deleteById(id);
        return ResponseEntity.ok("Tópico excluído com sucesso");
    }
}
