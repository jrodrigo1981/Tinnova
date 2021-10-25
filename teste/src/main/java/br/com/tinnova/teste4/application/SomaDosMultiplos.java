package br.com.tinnova.teste4.application;

import java.util.Random;

public class SomaDosMultiplos {

	public static void main(String[] args) {

		Random random = new Random();
		int numero = random.nextInt(100);
		int soma = 0;
		System.out.println("O numero sorteado foi: " + numero);
		
		for(int i=numero; i>0; i--) {
			if(i%3 == 0 || i%5 == 0) {
				soma += i;
			}
		}
		
		System.out.println("A soma dos multiplos de 3 e 5 foi de : " + soma);
		
	}

}
