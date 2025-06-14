package com.reservaservice.demo.interfaces.controller;

import com.reservaservice.demo.domain.model.Reserva;
import com.reservaservice.demo.application.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reserva> listar() {
        return service.listar();
    }

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva) {
        return service.salvar(reserva);
    }
}