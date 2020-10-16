package edu.curso;

import java.util.HashSet;
import java.util.Set;

public class TesteSet {
	
	public static void main(String[] args) {
		
		Set<String> conjunto = new HashSet<>();
		System.out.println(conjunto.add("Celular"));
		System.out.println(conjunto.add("Tv"));
		System.out.println(conjunto.add("Notebook"));
		System.out.println(conjunto.add("Livro"));
		System.out.println(conjunto.add("Livro"));
		System.out.println(conjunto.add("Agua"));
		
		for (String s : conjunto) {
			System.out.println(s);
		}
		
		System.out.println("Tem a palavra Notebook no conjunto");
		System.out.println(conjunto.contains("Notebook"));
		
	}

}
