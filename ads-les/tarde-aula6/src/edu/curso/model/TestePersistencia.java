package edu.curso.model;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistencia {

	public static void main(String[] args) {
		System.out.println("Inicio");
		Incidente i1 = new Incidente();
		i1.setId(1);
		i1.setTitulo("Teste de incidente 1");
		i1.setAbertura(LocalDateTime.now());
		i1.setCategoria("Computador");
		i1.setDescricao("Teste de abertura de incidente");
		i1.setStatus("aberto");
		i1.setFechamento(i1.getAbertura().plusDays(4));
		
		System.out.println("Executando");
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("INCIDENTES");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(i1);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
