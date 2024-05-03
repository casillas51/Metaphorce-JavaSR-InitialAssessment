package mx.metaphorce.boosters.sr.InitialAssessment.service;

import lombok.extern.slf4j.Slf4j;
import mx.metaphorce.boosters.sr.InitialAssessment.configuration.TestBase;
import mx.metaphorce.boosters.sr.InitialAssessment.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
public class UsuarioServiceTest extends TestBase {

    @Autowired
    UsuarioService usuarioService;

    /** Prueba de guardar un usuario */
    @Test
    void saveTest() {
        Usuario usuario = new Usuario(null,
                "UsuarioService", "123456", "ADMIN");

        Usuario nuevoUsuario = usuarioService.save(usuario);

        assertNotNull(nuevoUsuario, "El usuario no puede ser nulo");
        assertNotNull(nuevoUsuario.getIdUsuario(), "El id del usuario no puede ser nulo");

        log.info(String.format("Usuario creado: %s", nuevoUsuario));
    }

    /** Prueba de obtener un usuario por id */
    @Test
    void getById() {
        Usuario usuario = usuarioService.getById(10L);

        assertNotNull(usuario, "El usuario no puede ser nulo");
        assertNotNull(usuario.getIdUsuario(), "El id del usuario no puede ser nulo");

        log.info(String.format("Usuario obtenido: %s", usuario));
    }

    /** Prueba de actualizar un usuario */
    @Test
    void update() {
        Usuario usuario = usuarioService.getById(30L);

        assertNotNull(usuario, "El usuario no puede ser nulo");
        assertNotNull(usuario.getIdUsuario(), "El id del usuario no puede ser nulo");

        usuario.setNombreUsuario("Usuario Modificado");

        Usuario usuarioModificado = usuarioService.update(usuario);

        assertNotNull(usuarioModificado, "El usuario no puede ser nulo");
        assertNotNull(usuarioModificado.getIdUsuario(), "El id del usuario no puede ser nulo");

        log.info(String.format("Usuario modificado: %s", usuarioModificado));
    }

    /** Prueba de actualizar un usuario que no existe */
    @Test
    void update_whenUserDoesNotExist() {
        Usuario usuario = new Usuario(100L,
                "Usuario", "123456", "ADMIN");

        Usuario usuarioModificado = usuarioService.update(usuario);

        assertNull(usuarioModificado, "El usuario debe ser nulo");

        log.info("Usuario no existe");
    }

    /** Prueba de eliminar un usuario */
    @Test
    void delete() {
        Usuario usuario = usuarioService.getById(1L);

        assertNotNull(usuario, "El usuario no puede ser nulo");
        assertNotNull(usuario.getIdUsuario(), "El id del usuario no puede ser nulo");

        usuarioService.delete(usuario.getIdUsuario());

        usuario = usuarioService.getById(1L);
        assertNull(usuario, "El usuario debe ser nulo");

        log.info("Usuario eliminado");
    }

    /** Prueba de obtener todos los usuarios */
    @Test
    void getAll() {
        Iterable<Usuario> usuarioIterable = usuarioService.getAll();

        assertNotNull(usuarioIterable, "La lista de usuarios no puede ser nula");

        usuarioIterable.forEach(usuario -> {
            assertNotNull(usuario, "El usuario no puede ser nulo");
            assertNotNull(usuario.getIdUsuario(), "El id del usuario no puede ser nulo");
            log.info(String.format("Usuario obtenido: %s", usuario));
        });
    }
}