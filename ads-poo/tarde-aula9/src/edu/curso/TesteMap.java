package edu.curso;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TesteMap {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("0001", "João");
		Aluno a2 = new Aluno("0002", "Maria");
		Aluno a3 = new Aluno("0003", "Antonio");
		
		Map<String, Aluno> mapa = new HashMap<>();
		mapa.put("PM", a2);
		mapa.put("PROGRAMMER", a3);
		mapa.put("PROCESS", a1);
		
		Aluno a = mapa.get("PM");
		System.out.println(a);
		
		System.out.println("----------------- Chaves ---------------");
		Set<String> chaves = mapa.keySet();
		for (String chave: chaves) { 
			System.out.println(chave);
		}
		System.out.println("----------------- Valores ---------------");
		Collection<Aluno> valores = mapa.values();
		for (Aluno aluno : valores) { 
			System.out.println(aluno);
		}
	}
}
