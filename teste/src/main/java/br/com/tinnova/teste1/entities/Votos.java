package br.com.tinnova.teste1.entities;

public class Votos {

	private Integer totalDeEleitores;
	private Integer votosValidos;
	private Integer votosBrancos;
	private Integer nulos;

	
	
	public void setTotalDeEleitores(Integer totalDeEleitores) {
		this.totalDeEleitores = totalDeEleitores;
	}

	public void setVotosValidos(Integer votosValidos) {
		this.votosValidos = votosValidos;
	}

	public void setVotosBrancos(Integer votosBrancos) {
		this.votosBrancos = votosBrancos;
	}

	public void setNulos(Integer nulos) {
		this.nulos = nulos;
	}

	public void percentualDeVotosValidos() {
		Double total = ((double) votosValidos / totalDeEleitores) * 100;
		System.out.printf("O percentual de votos v�lidos em rela��o ao total de eleitores � de %.2f%% \n", total);
	}
	
	public void percentualDeVotosEmBranco() {
		Double total = ((double) votosBrancos / totalDeEleitores) * 100;
		System.out.printf("O percentual de votos em branco em rela��o ao total de eleitores � de %.2f%% \n", total);
	}
	
	public void percentualDeVotosNulos() {
		Double total = ((double) nulos / totalDeEleitores) * 100;
		System.out.printf("O percentual de votos nulos em rela��o ao total de eleitores � de %.2f%% \n", total);
	}
	

}
