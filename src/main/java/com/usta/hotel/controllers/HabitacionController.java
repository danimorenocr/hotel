package com.usta.hotel.controllers;


import com.usta.hotel.entities.HabitacionEntity;
import com.usta.hotel.entities.ReservaEntity;
import com.usta.hotel.models.services.HabitacionService;
import com.usta.hotel.models.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Comparator;
import java.util.List;

@Controller
public class HabitacionController {
    @Autowired
    private HabitacionService habitacionService;

    @Autowired
    private ReservaService reservaService;

    @GetMapping(value = "/habitacion")
    public String listarHab(Model model) {
        model.addAttribute("title", "Room list");
        model.addAttribute("urlRegistro", "/crearHabitacion");
        List<HabitacionEntity> lista = habitacionService.findAll();
        lista.sort(Comparator.comparing(HabitacionEntity::getIdHabitacion));
        model.addAttribute("habitaciones", lista);
        return "/habitaciones/listarHabitaciones";

    }

    /*------------------------------------------------------------------------------------*/

    @PostMapping(value = "/eliminarHabitacion/{id}")
    public String eliminarHabitacion(@PathVariable(value = "id") Long id, RedirectAttributes redirectAttributes) {
        if (id > 0) {
            HabitacionEntity habitacion = habitacionService.findById(id);
            if (habitacion != null) {

                List<ReservaEntity> reservaEntities = reservaService.findByHabitacion(habitacion);
                if (!reservaEntities.isEmpty()) {
                    redirectAttributes.addFlashAttribute("error", "Cannot delete room: there are reservations associated");
                    return "redirect:/habitacion";
                }
                habitacionService.deletebyId(id);
                redirectAttributes.addFlashAttribute("success", "Room deleted successfully");
            }

        } else {

            redirectAttributes.addFlashAttribute("error", "Invalid ID");
        }
        return "redirect:/habitacion";

    }
}
