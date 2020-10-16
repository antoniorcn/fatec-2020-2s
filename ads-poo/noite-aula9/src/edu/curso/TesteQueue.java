package edu.curso;

import java.util.PriorityQueue;
import java.util.Queue;

public class TesteQueue {
	
	public static void main(String[] args) {
		System.out.println("Sistema de fila");
		Queue<Pessoa> pessoas = new PriorityQueue<>();
		Pessoa p1 = new Pessoa("Antonio", 39);
		Pessoa p2 = new Pessoa("Mario", 61);
		Pessoa p3 = new Pessoa("Camila", 28);
		Pessoa p4 = new Pessoa("Vovozona", 82);
		
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p4);
		pessoas.add(p3);
		
		int indice = 1;
		while (pessoas.size() > 0) { 
			System.out.println("------- " + indice + "º fila");
			Pessoa p = pessoas.poll();
			System.out.println(p.getNome());
			indice++;
		}
		
		System.out.println("---------Sobraram na fila: ");
		for (Pessoa pessoa : pessoas) { 
			System.out.println(pessoa.getNome());
		}
	}

}
