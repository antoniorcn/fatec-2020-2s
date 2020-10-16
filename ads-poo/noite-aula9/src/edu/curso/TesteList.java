package edu.curso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TesteList {
	public static void exibirLista(List<String> lista) { 
		for (String s : lista) { 
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("Tv");
		lista.add("Notebook");
		lista.add("Fatec");
		lista.add("Livro");
		lista.add("Livro");
		
		lista.remove("Livro");
		lista.remove("Livro");
		

		exibirLista(lista);
		
		System.out.println("Elemento 2");
		System.out.println(lista.get(2));
	}
}
