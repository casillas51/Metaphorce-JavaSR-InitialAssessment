package mx.metaphorce.boosters.sr.InitialAssessment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    /** Id de usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    /** Nombre de usuario */
    @Column(name = "nombreUsuario", nullable = false, unique = true)
    private String nombreUsuario;

    /** Contrasenia */
    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    /** Rol */
    @Column(name = "rol", nullable = false)
    private String rol;

}
