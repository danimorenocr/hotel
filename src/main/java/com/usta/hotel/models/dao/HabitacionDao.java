package com.usta.hotel.models.dao;

import com.usta.hotel.entities.HabitacionEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

//id = Long
public interface HabitacionDao extends CrudRepository<HabitacionEntity, Long> {
    //ACTUALIZAR DISPONIBILIDAD
    //Consulta para crd
    @Transactional
    //Para Update
    @Modifying
    //?1 = SOLO TOMA UN CAMPO
    @Query("UPDATE HabitacionEntity SET disponibilidad = FALSE WHERE idHabitacion=?1 ")
    public void changeState(Long idHabitacion);

    //TRAE SOLO LA HABITACIÓN REQUERIDA
    @Transactional
    @Query("SELECT HA FROM HabitacionEntity  HA WHERE HA.idHabitacion =?1")
    public HabitacionEntity viewDetail(Long idHabitacion);
}
