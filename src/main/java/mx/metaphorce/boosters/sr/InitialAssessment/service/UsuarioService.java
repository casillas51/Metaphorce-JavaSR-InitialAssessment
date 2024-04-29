package mx.metaphorce.boosters.sr.InitialAssessment.service;

import mx.metaphorce.boosters.sr.InitialAssessment.dao.IUsuarioDAO;
import mx.metaphorce.boosters.sr.InitialAssessment.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return usuarioDAO.save(usuario);
    }

    /**
     * Obtiene un usuario por id
     * @param id - id
     * @return Usuario
     */
    public Usuario getById(Long id) {
        return usuarioDAO.findById(id).orElse(null);
    }

    /**
     * Actualiza un usuario
     * @param usuario - Usuario
     * @return Usuario
     */
    public Usuario update(Usuario usuario) {
        if (usuarioDAO.existsById(usuario.getIdUsuario())) {
            return usuarioDAO.save(usuario);
        }
        return null;
    }

    /**
     * Elimina un usuario
     * @param id - id
     */
    public void delete(Long id) {
        usuarioDAO.deleteById(id);
    }

    /**
     * Obtiene todos los usuarios
     * @return Iterable<Usuario>
     */
    public Iterable<Usuario> getAll() {
        return usuarioDAO.findAll();
    }
}