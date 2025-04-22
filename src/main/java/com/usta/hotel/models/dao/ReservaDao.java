package com.usta.hotel.models.dao;

import com.usta.hotel.entities.HabitacionEntity;
import com.usta.hotel.entities.ReservaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReservaDao extends CrudRepository<ReservaEntity, Long> {

    @Transactional
    @Query("SELECT RE FROM ReservaEntity RE WHERE RE.idReserva=?1")
    public ReservaEntity viewDetail(Long id);

    @Transactional
    @Query("SELECT r FROM ReservaEntity r JOIN r.habitacion h WHERE h = :habitacion")
    List<ReservaEntity> findByHabitacion(@Param("habitacion")HabitacionEntity habitacion);
}
