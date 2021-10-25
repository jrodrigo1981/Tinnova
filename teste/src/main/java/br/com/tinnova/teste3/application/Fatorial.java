package br.com.tinnova.teste3.application;

import java.util.Random;

public class Fatorial {

	public static void main(String[] args) {
		
		Random randon = new Random();
		int numero = randon.nextInt(10);
		int count = numero;
		int total = 1;
		
		
		System.out.print("O numero sorteado é " + numero + ". E o fatorial dele é: ");
		
		for(int i=1; i <= count; i++) {
			total = total * i;
			
			
		}
		System.out.println(total);
		System.out.println(numero + "! = " + total);
	}

}
