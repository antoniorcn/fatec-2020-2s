package edu.curso;

class ObjetoLigado { 
	long[] vetor = new long[100000];
	ObjetoLigado proximo;
}

public class EstourarMemoriaHeapListaLigada {

	public static void main(String[] args) {
		ObjetoLigado root = new ObjetoLigado();
		ObjetoLigado ultimo = root;
		while (true) { 
			ultimo.proximo = new ObjetoLigado();
			ultimo = ultimo.proximo;
		}

	}

}
