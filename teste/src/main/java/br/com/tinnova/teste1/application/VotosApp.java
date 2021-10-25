package br.com.tinnova.teste1.application;

import java.util.Locale;

import br.com.tinnova.teste1.entities.Votos;

public class VotosApp {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);

		Votos eleicao = new Votos();
		eleicao.setTotalDeEleitores(1000);
		eleicao.setVotosValidos(800);
		eleicao.setVotosBrancos(150);
		eleicao.setNulos(50);
		
		

		eleicao.percentualDeVotosValidos();
		eleicao.percentualDeVotosEmBranco();
		eleicao.percentualDeVotosNulos();
		
	}
}
