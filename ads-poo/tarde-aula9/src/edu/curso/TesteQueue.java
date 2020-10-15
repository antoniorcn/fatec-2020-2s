package edu.curso;

import java.util.PriorityQueue;
import java.util.Queue;

public class TesteQueue {
	
	public static void main(String[] args) {
		Queue<Aluno> queue = new PriorityQueue<Aluno>();
		Aluno a1 = new Aluno("0001", "Antonio");
		Aluno a2 = new Aluno("0002", "João");
		Aluno a3 = new Aluno("0003", "Maria");
		
		queue.add(a3);
		queue.add(a2);
		queue.add(a1);
		
		System.out.println(queue.poll());
		
		System.out.println(queue.poll());
		
		System.out.println("Itens restantes na fila: ");
		for (Aluno a : queue) { 
			System.out.println(a);
		}
		
		
	}

}
