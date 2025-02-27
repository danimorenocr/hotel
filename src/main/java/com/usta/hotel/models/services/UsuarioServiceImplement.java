package com.usta.hotel.models.services;

import com.usta.hotel.entities.HabitacionEntity;
import com.usta.hotel.entities.UsuarioEntity;
import com.usta.hotel.models.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDAO;

    @Override
    public List<UsuarioEntity> findAll() {
        return (List<UsuarioEntity>) usuarioDAO.findAll();
    }

    @Override
    public void save(UsuarioEntity usuario) {
    usuarioDAO.save(usuario);
    }

    @Override
    public UsuarioEntity findById(Long cedula) {
        return usuarioDAO.findById(cedula).orElse(null);
    }

    @Override
    public void deletebyId(Long cedula) {
        usuarioDAO.deleteById(cedula);
    }

    @Override
    public UsuarioEntity actualizar(UsuarioEntity usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public void changeState(Long cedula) {
        usuarioDAO.changeState(cedula);
    }


    @Override
    public UsuarioEntity findByEmail(String email) {
        return usuarioDAO.findByemail(email);
    }
}
