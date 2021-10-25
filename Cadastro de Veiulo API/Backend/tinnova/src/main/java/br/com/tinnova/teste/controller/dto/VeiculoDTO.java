package br.com.tinnova.teste.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.tinnova.teste.model.Marca;
import br.com.tinnova.teste.model.Veiculo;

public class VeiculoDTO {

	private Long id;
	private String veiculo;
	private Marca marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;
	private LocalDateTime created;
	private LocalDateTime updated;

	public VeiculoDTO(Veiculo veiculo) {
		super();
		this.id = veiculo.getId();
		this.veiculo = veiculo.getVeiculo();
		this.marca = veiculo.getMarca();
		this.ano = veiculo.getAno();
		this.descricao = veiculo.getDescricao();
		this.vendido = veiculo.getVendido();
		this.created = veiculo.getCreated();
		this.updated = veiculo.getUpdated();
	}

	public Long getId() {
		return id;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public Marca getMarca() {
		return marca;
	}

	public Integer getAno() {
		return ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public static List<VeiculoDTO> converter(List<Veiculo> veiculos) {
		return veiculos.stream().map(VeiculoDTO::new).collect(Collectors.toList());
	}

}
