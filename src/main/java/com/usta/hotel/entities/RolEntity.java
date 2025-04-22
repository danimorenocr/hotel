package com.usta.hotel.entities;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

//GENERA GETTERS AND SETTERS
@Data
//INDICA Q ES UNA ENTIDAD
@Entity
//NOMBRE DE LA TABLA
@Table(name = "ROLES")

public class RolEntity implements Serializable {
    // CREA EL NUMERO DEL ID
    private static final long serialVersionUID = 1L;

    @Id
    //cuando llave primaria es autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "rol", length = 20, nullable = false)
    private String rol;


    //Establecer la parte de seguridad - se llena automaticamente, no con formularios
    public RolEntity(String rol) {
        super();
        this.rol = rol;

    }

    public RolEntity() {

    }
}
