package br.com.tinnova.teste.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.tinnova.teste.model.Marca;
import br.com.tinnova.teste.model.Veiculo;
import br.com.tinnova.teste.repository.VeiculosRepository;

public class AtualizarVeiculoForm {

	@NotEmpty
	@NotNull
	private String veiculo;
	@NotNull
	private Marca marca;
	@NotNull
	private Integer ano;
	@NotEmpty
	@NotNull
	private String Descricao;
	@NotNull
	private Boolean vendido;

	private LocalDateTime updated;

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

	public Veiculo atualizar(Long id, VeiculosRepository veiculosRepository) {
		Veiculo veiculo = veiculosRepository.getOne(id);
		veiculo.setVeiculo(this.veiculo);
		veiculo.setMarca(this.marca);
		veiculo.setAno(this.ano);
		veiculo.setDescricao(this.Descricao);
		veiculo.setUpdated(LocalDateTime.now());
		veiculo.setVendido(this.vendido);
		return veiculo;

	}

}
