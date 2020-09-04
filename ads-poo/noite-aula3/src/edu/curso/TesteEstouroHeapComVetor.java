package edu.curso;

import java.util.ArrayList;
import java.util.List;

class ObjetoPesado { 
	long[] vetor = new long[10000];
}

public class TesteEstouroHeapComVetor {

	public static void main(String[] args) {
		List<ObjetoPesado> lista = new ArrayList<ObjetoPesado>();
		
		while (true) { 
			ObjetoPesado o = new ObjetoPesado();
			lista.add(o);
		}
	}

}
