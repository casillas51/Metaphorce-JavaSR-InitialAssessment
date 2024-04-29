package mx.metaphorce.boosters.sr.InitialAssessment.dao;

import mx.metaphorce.boosters.sr.InitialAssessment.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDAO extends CrudRepository<Usuario, Long>  {
}
