package edu.curso;

class ObjetoPesado2 { 
	long[] vetor = new long[10000];
	ObjetoPesado2 proximo;
}

public class TesteEstouroHeapComLista {
	public static void main(String[] args) {
		ObjetoPesado2 root = new ObjetoPesado2();
		ObjetoPesado2 ultimo = root;
		while(true) { 
			ultimo.proximo = new ObjetoPesado2();
			ultimo = ultimo.proximo;
		}

	}

}
