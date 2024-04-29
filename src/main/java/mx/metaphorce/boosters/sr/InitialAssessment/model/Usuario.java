package mx.metaphorce.boosters.sr.InitialAssessment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {

    /** Id de usuario */
    @Id
    @GeneratedValue
    private Long idUsuario;

    /** Nombre de usuario */
    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    /** Contrasenia */
    @Column(name = "contrasenia")
    private String contrasenia;

    /** Rol */
    @Column(name = "rol")
    private String rol;

}
