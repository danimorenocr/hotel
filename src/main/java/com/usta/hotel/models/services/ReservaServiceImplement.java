package com.usta.hotel.models.services;

import com.usta.hotel.entities.HabitacionEntity;
import com.usta.hotel.entities.ReservaEntity;
import com.usta.hotel.models.dao.ReservaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservaServiceImplement implements ReservaService {

    //Inyeccion de datos
    @Autowired
    private ReservaDao reservaDAO;

    @Override
    @Transactional
    public List<ReservaEntity> findAll() {
        return (List<ReservaEntity>) reservaDAO.findAll();
    }

    @Override
    @Transactional
    public void save(ReservaEntity reserva) {
        reservaDAO.save(reserva);
    }

    @Override
    @Transactional
    public ReservaEntity findById(Long id) {
        return reservaDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deletebyId(Long id) {
        reservaDAO.deleteById(id);
    }

    @Override
    @Transactional
    public ReservaEntity actualizar(ReservaEntity reserva) {
        return reservaDAO.save(reserva);
    }

    @Override
    @Transactional
    public ReservaEntity viewDetail(Long id) {
        return reservaDAO.viewDetail(id);
    }

    @Override
    @Transactional
    public List<ReservaEntity> findByHabitacion(HabitacionEntity habitacion) {
        return reservaDAO.findByHabitacion(habitacion);
    }

}
