package edu.curso;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Long>{

	Iterable<Contato> findByNome(String nome);
	
	@Query("SELECT c FROM Contato c WHERE c.nome LIKE %:nome% ")
	Iterable<Contato> searchLikeByNome(@Param("nome") String nome);
}
