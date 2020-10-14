package edu.curso;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteHibernate {
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		a1.setRa("11111");
		a1.setNome("João");
		a1.setNascimento(LocalDate.now());
		
		Aluno a2 = new Aluno();
		a2.setRa("22222");
		a2.setNome("Maria");
		a2.setNascimento(LocalDate.now());
		
		SalaAula s1 = new SalaAula();
		s1.setCapacidade(10);
		s1.setNumero("001");
		
		a1.setSalaAula(s1);
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ALUNOS");
		
		EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(a1);
			em.persist(a2);
			em.getTransaction().commit();
		em.close();
		
		emf.close();
	}

}
