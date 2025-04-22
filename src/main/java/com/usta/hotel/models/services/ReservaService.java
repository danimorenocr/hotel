package com.usta.hotel.models.services;

import com.usta.hotel.entities.HabitacionEntity;
import com.usta.hotel.entities.ReservaEntity;

import java.util.List;

public interface ReservaService {

    public List<ReservaEntity> findAll();

    public void save(ReservaEntity reserva);

    public ReservaEntity findById(Long id);

    public void deletebyId(Long id);

    public ReservaEntity actualizar(ReservaEntity reserva);

    public ReservaEntity viewDetail(Long id);

    public List<ReservaEntity> findByHabitacion(HabitacionEntity habitacion);
}
