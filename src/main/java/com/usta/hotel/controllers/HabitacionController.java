package com.usta.hotel.controllers;


import com.usta.hotel.entities.HabitacionEntity;
import com.usta.hotel.models.services.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HabitacionController {
    @Autowired
    private HabitacionService habitacionService;

    @GetMapping(value = "/habitacion")
    public String listarHab(Model model) {
        model.addAttribute("title", "Room list");
        model.addAttribute("urlRegistro", "/crearHabitacion");
        List<HabitacionEntity> lista = habitacionService.findAll();
        model.addAttribute("habitaciones", lista);
        return "/habitaciones/listarHabitaciones";

    }
}
