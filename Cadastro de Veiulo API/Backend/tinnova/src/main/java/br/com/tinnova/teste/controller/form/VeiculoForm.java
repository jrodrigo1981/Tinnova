package br.com.tinnova.teste.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.tinnova.teste.model.Marca;
import br.com.tinnova.teste.model.Veiculo;
import br.com.tinnova.teste.repository.VeiculosRepository;

public class VeiculoForm {

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

	public Veiculo converter(VeiculosRepository veiculoRepository) {
		return new Veiculo(veiculo, marca, ano, Descricao);
	}

}
