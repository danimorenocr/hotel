package com.usta.hotel.models.services;

import com.usta.hotel.entities.RolEntity;

import java.util.List;

public interface RolService {

    public List<RolEntity> findAll();

    public void save(RolEntity rol);

    public RolEntity findById(Long id);

    public void deletebyId(Long id);

    public RolEntity actualizar(RolEntity rol);
}
