package com.usta.hotel.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "RESERVAS")

public class ReservaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    //cuando llave primaria es autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ini", nullable = false)
    private Date fechaIni;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @NotNull
    @Column(name = "cant_hab", nullable = false)
    private Integer cantHab;

    //Conexion tabla usuarios
    @NotNull
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne(fetch = FetchType.LAZY) //Conexion lazy = trae pocos  datos (solo cedula del usuario)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UsuarioEntity cedula;

    //Conexion tabla de rompimiento reserva - habitacion
    //NO SE UTILIZA @NOTNULL PQ NO SE VA A GENERAR CAMPOS SINO LA TABLA DE ROMPIMIENTO
    @ManyToMany(fetch = FetchType.EAGER)

    //Nombre de la tabla de rompimiento y conecctarlas a las otras tablas
    @JoinTable(name = "reservas_hab",
            joinColumns = @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva"),
            inverseJoinColumns = @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion")
    )
    private Collection<HabitacionEntity> habitacion;


}