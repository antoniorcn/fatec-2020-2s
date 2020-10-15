package edu.curso;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class TesteHibernate {
	
	public static void adicionarAlunosSala(EntityManager em) { 
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
		
		em.getTransaction().begin();
		em.persist(a1);
		em.persist(a2);
		em.getTransaction().commit();
	}
	
	public static void listarAlunos(EntityManager em) { 
		TypedQuery<Aluno> qry = em.createQuery("select a from Aluno a", Aluno.class);
		List<Aluno> alunos = qry.getResultList();
		for (Aluno a : alunos) { 
			System.out.println(a);
			System.out.println("Sala de Aula: " + a.getSalaAula());
		}
	}
	
	public static void getAluno(EntityManager em, long id) { 
		Aluno a = em.find(Aluno.class, id);
		if (a != null) { 
			System.out.println("Aluno encontrado: " + a);
		} else { 
			System.out.println("Aluno não encontrado");
		}
	}
	
	public static void atualizarDados(EntityManager em) { 
		Aluno a = em.find(Aluno.class, 1l);
		em.getTransaction().begin();
		a.setNome("Antonio Rodrigues");
		em.getTransaction().commit();
	}
	
	public static void pesquisarComParametros(EntityManager em, String ra) { 
		TypedQuery<Aluno> qry = 
				em.createQuery("select a from Aluno a where ra like :valorRA", 
						Aluno.class);
		qry.setParameter("valorRA", ra);
		List<Aluno> alunos = qry.getResultList();
		for (Aluno a : alunos) { 
			System.out.println(a);
		}
	}
	
	public static void removerAluno(EntityManager em) {
		Aluno a = em.find(Aluno.class, 1l);
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ALUNOS");
		
		EntityManager em = emf.createEntityManager();
		// adicionarAlunosSala(em);
		// listarAlunos(em);
		// getAluno(em, 1);
		// atualizarDados(em);
		// pesquisarComParametros(em, "%1%");
		removerAluno(em);
		em.close();
		
		emf.close();
	}

}
