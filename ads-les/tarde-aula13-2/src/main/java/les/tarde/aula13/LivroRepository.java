package les.tarde.aula13;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

	@Query("SELECT l from Livro l WHERE l.titulo like %:titulo%")
	List<Livro> findByTitulo(@Param("titulo") String titulo);
}
