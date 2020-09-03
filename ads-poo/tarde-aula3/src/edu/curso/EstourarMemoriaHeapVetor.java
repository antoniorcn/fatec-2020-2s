package edu.curso;

import java.util.ArrayList;
import java.util.List;

class Objeto { 
	long[] vetor = new long[100000];
}

public class EstourarMemoriaHeapVetor {
	public static void main(String[] args) {
		List<Objeto> lista = new ArrayList<>();
		while(true) { 
			Objeto o = new Objeto();
			lista.add(o);
		}
	}
}
