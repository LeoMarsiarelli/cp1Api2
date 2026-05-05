package br.com.fiap.cp1Api2.repositories;

import br.com.fiap.cp1Api2.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
