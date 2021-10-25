package br.com.tinnova.teste2.application;

public class BubbleSort {

	public static void main(String[] args) {

		int[] vetor = { 5, 3, 2, 4, 7, 1, 0, 6 };
		int x = 0;
		int tamanho = vetor.length - 1;

		System.out.print("Vetor desorganizado = {");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(" " + vetor[i]);
		}
		System.out.println(" }");

		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < tamanho; j++) {
				if (vetor[j] > vetor[j + 1]) {
					x = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = x;
				}
			}
			tamanho--;
		}

		System.out.print("Vetor organizado = {");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(" " + vetor[i]);
		}
		System.out.println(" }");
	}

}
