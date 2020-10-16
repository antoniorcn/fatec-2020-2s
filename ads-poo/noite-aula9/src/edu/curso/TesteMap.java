package edu.curso;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TesteMap {
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("Maria", 23);
		Pessoa p2 = new Pessoa("João", 24);
		Pessoa p3 = new Pessoa("Dora", 45);
		Pessoa p4 = new Pessoa("Euclides", 39);
		
		Map<String, Pessoa> mapa = new HashMap<>();
		mapa.put("MARIA", p1);
		mapa.put("JOAO", p2);
		mapa.put("DORA", p3);
		mapa.put("EUCLIDES", p4);
		
		Pessoa p = mapa.get("DORA");
		System.out.println(p.getNome());
		
		System.out.println("-------------- Chaves");
		Set<String> chaves = mapa.keySet();
		for (String chave : chaves) { 
			System.out.println(chave);
		}
		
		System.out.println("-------------- Valores");
		Collection<Pessoa> col = mapa.values();
		for (Pessoa pessoa : col) { 
			System.out.println(pessoa.getNome());
		}
	}
}
