package com.usta.hotel.models.services;

import com.usta.hotel.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioService {

    public List<UsuarioEntity> findAll();

    public void save(UsuarioEntity usuario);

    public UsuarioEntity findById(Long cedula);

    public void deletebyId(Long cedula);

    public UsuarioEntity actualizar(UsuarioEntity usuario);

    public void changeState(Long cedula);

    public UsuarioEntity findByEmail(String email);
}
