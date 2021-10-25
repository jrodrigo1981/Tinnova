package br.com.tinnova.teste.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tinnova.teste.model.Marca;
import br.com.tinnova.teste.model.Veiculo;

public interface VeiculosRepository extends JpaRepository<Veiculo, Long> {

	List<Veiculo> findByVeiculo(String nomeVeiculo);

	List<Veiculo> findByMarca(Marca marca);

	List<Veiculo> findByVendido(Boolean valor);
	
	List<Veiculo>findByAno(Integer ano);

	List<Veiculo> findByCreated(LocalDateTime data);

	

}
