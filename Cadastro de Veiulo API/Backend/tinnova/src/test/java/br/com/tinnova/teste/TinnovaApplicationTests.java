package br.com.tinnova.teste;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tinnova.teste.model.Veiculo;
import br.com.tinnova.teste.repository.VeiculosRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TinnovaApplicationTests {
	
//	@Autowired
//	private TestEntityManager entityManager;
	
	@Autowired
	VeiculosRepository repository;

	@Test
	public void semVeiculoRetornaListaVazia() {
		 Iterable<Veiculo> veiculos = repository.findAll();
		 
		 assertThat(veiculos).isEmpty();
		
	}

}
