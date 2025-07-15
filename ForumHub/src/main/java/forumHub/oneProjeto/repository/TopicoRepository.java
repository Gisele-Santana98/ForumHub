package forumHub.oneProjeto.repository;

import forumHub.oneProjeto.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
