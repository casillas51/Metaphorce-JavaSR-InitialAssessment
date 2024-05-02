package mx.metaphorce.boosters.sr.InitialAssessment.service;

import lombok.extern.slf4j.Slf4j;
import mx.metaphorce.boosters.sr.InitialAssessment.dao.IUsuarioDAO;
import mx.metaphorce.boosters.sr.InitialAssessment.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioService {

    /** DAO de usuario */
    @Autowired
    IUsuarioDAO usuarioDAO;

    /**
     * Guarda un usuario
     * @param usuario - usuario
     * @return Usuario
     */
    public Usuario save(Usuario usuario) {
        log.info(String.format("Guardando usuario: %s", usuario));
        return usuarioDAO.save(usuario);
    }

    /**
     * Obtiene un usuario por id
     * @param id - id
     * @return Usuario
     */
    public Usuario getById(Long id) {
        log.info(String.format("Obteniendo usuario por id: %s", id));
        return usuarioDAO.findById(id).orElse(null);
    }

    /**
     * Actualiza un usuario
     * @param usuario - Usuario
     * @return Usuario
     */
    public Usuario update(Usuario usuario) {
        log.info(String.format("Actualizando usuario: %s", usuario));
        if (usuarioDAO.existsById(usuario.getIdUsuario())) {
            return usuarioDAO.save(usuario);
        }

        log.info(String.format("El usuario con id %s no existe", usuario.getIdUsuario()));
        return null;
    }

    /**
     * Elimina un usuario
     * @param id - id
     */
    public void delete(Long id) {
        log.info(String.format("Eliminando usuario por id: %s", id));
        usuarioDAO.deleteById(id);
    }

    /**
     * Obtiene todos los usuarios
     * @return Iterable<Usuario>
     */
    public Iterable<Usuario> getAll() {
        log.info("Obteniendo todos los usuarios");
        return usuarioDAO.findAll();
    }
}