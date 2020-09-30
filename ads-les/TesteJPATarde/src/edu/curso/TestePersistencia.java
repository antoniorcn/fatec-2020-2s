package edu.curso;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
public class TestePersistencia {
	public static void inserirDados(EntityManager em) { 
		Incidente i1 = new Incidente();
		i1.setId(1);
		i1.setTitulo("Teste de incidente 1");
		i1.setAbertura(LocalDateTime.now());
		i1.setCategoria("Computador");
		i1.setDescricao("Teste de abertura de incidente 1");
		i1.setStatus("aberto");
		i1.setFechamento(i1.getAbertura().plusDays(4));
		
		Incidente i2 = new Incidente();
		i2.setId(2);
		i2.setTitulo("Teste de incidente 2");
		i2.setAbertura(LocalDateTime.now());
		i2.setCategoria("Monitor");
		i2.setDescricao("Teste de abertura de incidente 2");
		i2.setStatus("aberto");
		i2.setFechamento(i2.getAbertura().plusDays(6));
		
		Acao a1 = new Acao();
		a1.setDescricao("Desmontando o computador para conserto");
		a1.setTipo("tecnica");
		a1.setUsuario("Antonio");
		a1.setId(1);
		a1.setIncidente(i1);
		
		Acao a2 = new Acao();
		a2.setDescricao("Trocando a placa mãe do computador");
		a2.setTipo("tecnica");
		a2.setUsuario("DTI");
		a2.setId(2);
		a2.setIncidente(i1);
		
		Acao a3 = new Acao();
		a3.setDescricao("Configurando o driver do monitor no Windows 10");
		a3.setTipo("tecnica");
		a3.setUsuario("DTI");
		a3.setId(3);
		a3.setIncidente(i2);
		
		em.getTransaction().begin();
		em.persist(i1);
		em.persist(i2);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.getTransaction().commit();
	}
	
	public static void consultar(EntityManager em) { 
		TypedQuery<Incidente> qry = 
				em.createQuery("select i from Incidente i", Incidente.class);
		List<Incidente> lista = qry.getResultList();
		for (Incidente i : lista) { 
			System.out.println(i);
		}
	}
	
	public static void consultarIncidente(EntityManager em, long id) { 
		Incidente i = em.find(Incidente.class, id);
		System.out.println(i.toString());
	}
	
	public static void fecharIncidente(EntityManager em, long id) {
		Incidente i = em.find(Incidente.class, id);
		em.getTransaction().begin();
		i.setStatus("fechado");
		em.getTransaction().commit();
		System.out.println(i.toString());
	}
	
	public static void main(String[] args) {
		System.out.println("Executando");
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("INCIDENTES");
		EntityManager em = emf.createEntityManager();
		
		fecharIncidente(em, 1l);
		
		em.close();
		emf.close();
	}
}
