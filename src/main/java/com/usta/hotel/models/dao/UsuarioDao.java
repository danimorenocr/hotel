package com.usta.hotel.models.dao;

import com.usta.hotel.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioDao extends CrudRepository<UsuarioEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE UsuarioEntity  SET estadoUsuario= FALSE  WHERE cedula=?1")
    public void changeState(Long cedula);

    @Transactional
    @Query("SELECT US FROM UsuarioEntity US WHERE US.email = ?1")
    public UsuarioEntity findByemail(String email);


}
