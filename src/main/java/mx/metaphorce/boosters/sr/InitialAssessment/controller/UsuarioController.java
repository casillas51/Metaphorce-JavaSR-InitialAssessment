package mx.metaphorce.boosters.sr.InitialAssessment.controller;

import mx.metaphorce.boosters.sr.InitialAssessment.service.UsuarioService;
import mx.metaphorce.boosters.sr.InitialAssessment.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    /**
     * Obtiene todos los usuarios
     * @return ResponseEntity<List<Usuario>>
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        return ResponseEntity.ok((List<Usuario>) usuarioService.getAll());
    }

    /**
     * Obtiene un usuario por id
     * @param id - id
     * @return ResponseEntity<Usuario>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un usuario
     * @param usuario - usuario
     * @return ResponseEntity<Usuario>
     */
    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    /**
     * Actualiza un usuario
     * @param usuario - usuario
     * @return ResponseEntity<Usuario>
     */
    @PutMapping
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario) {
        Usuario updatedUsuario = usuarioService.update(usuario);
        if (updatedUsuario != null) {
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un usuario
     * @param id - id
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}