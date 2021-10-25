package br.com.tinnova.teste.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.tinnova.teste.controller.dto.VeiculoDTO;
import br.com.tinnova.teste.controller.form.AtualizarVeiculoForm;
import br.com.tinnova.teste.controller.form.VeiculoForm;
import br.com.tinnova.teste.model.Marca;
import br.com.tinnova.teste.model.Veiculo;
import br.com.tinnova.teste.repository.VeiculosRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

	@Autowired
	private VeiculosRepository veiculosRepository;

//Listar todos os veiculos

	@GetMapping
	public List<VeiculoDTO> lista(String nomeVeiculo) {
		if (nomeVeiculo == null) {
			List<Veiculo> veiculos = veiculosRepository.findAll();
			return VeiculoDTO.converter(veiculos);
		} else {
			List<Veiculo> veiculos = veiculosRepository.findByVeiculo(nomeVeiculo);
			return VeiculoDTO.converter(veiculos);
		}
	}

//Listar veiculos por id

	@GetMapping("/{id}")
	public ResponseEntity<VeiculoDTO> detalhar(@PathVariable Long id) {
		Optional<Veiculo> veiculo = veiculosRepository.findById(id);
		if (veiculo.isPresent()) {
			return ResponseEntity.ok(new VeiculoDTO(veiculo.get()));
		}
		return ResponseEntity.notFound().build();
	}

//Listar veiculos por marca

	@GetMapping("marca/{marca}")
	public List<VeiculoDTO> listarMarca(@PathVariable Marca marca) {

		if (marca == null) {
			List<Veiculo> veiculos = veiculosRepository.findAll();
			return VeiculoDTO.converter(veiculos);
		} else {
			List<Veiculo> veiculos = veiculosRepository.findByMarca(marca);
			return VeiculoDTO.converter(veiculos);
		}

	}

	// Listar veiculos por nao vendido e vendido

	@GetMapping("vendido/{valor}")
	public List<VeiculoDTO> listarveiculosVendido(@PathVariable Boolean valor) {

		if (valor == true) {
			List<Veiculo> veiculos = veiculosRepository.findByVendido(valor);
			return VeiculoDTO.converter(veiculos);
		} else {
			List<Veiculo> veiculos = veiculosRepository.findByVendido(valor);
			return VeiculoDTO.converter(veiculos);
		}

	}

	// Listar veiculos por ano

	@GetMapping("ano/{numero}")
	public List<VeiculoDTO> listarveiculosPorDecada(@PathVariable int numero) {

		List<Veiculo> veiculos = veiculosRepository.findByAno(numero);
		return VeiculoDTO.converter(veiculos);

	}
	
	// Listar veiculos na ultima semana

		@GetMapping("ultimaSemana/{data}")
		public List<VeiculoDTO> listarveiculosPorData(@PathVariable LocalDateTime data) {

			List<Veiculo> veiculos = veiculosRepository.findByCreated(data);
			return VeiculoDTO.converter(veiculos);

		}

	@PostMapping
	public ResponseEntity<VeiculoDTO> cadastrar(@RequestBody @Valid VeiculoForm form, UriComponentsBuilder uriBuilder) {
		Veiculo veiculo = form.converter(veiculosRepository);
		veiculosRepository.save(veiculo);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDTO(veiculo));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VeiculoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarVeiculoForm form) {

		Optional<Veiculo> optional = veiculosRepository.findById(id);
		if (optional.isPresent()) {
			Veiculo veiculo = form.atualizar(id, veiculosRepository);
			return ResponseEntity.ok(new VeiculoDTO(veiculo));
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Veiculo> optional = veiculosRepository.findById(id);
		if (optional.isPresent()) {
			veiculosRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();

	}

}