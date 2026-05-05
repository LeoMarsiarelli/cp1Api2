package br.com.fiap.cp1Api2.repositories;

import br.com.fiap.cp1Api2.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
