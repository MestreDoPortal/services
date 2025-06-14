package com.salaservice.demo.interfaces.controller;

import com.salaservice.demo.domain.model.Sala;
import com.salaservice.demo.application.service.SalaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/api/sala")
public class SalaController {
    private final SalaService service;

    @Autowired
    public SalaController(SalaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sala> listar() {
        return service.listar();
    }

    @PostMapping
    public Sala criar(@RequestBody Sala sala) {
        return service.salvar(sala);
    }
    

@PostMapping("/{id}/reservar")
public ResponseEntity<?> reservarSala(
    @PathVariable Long id,
    @RequestBody String dataReserva) {
    
    System.out.println("Dado recebido: [" + dataReserva + "]"); // ← LOG CRÍTICO
    
    try {
        LocalDateTime data = LocalDateTime.parse(dataReserva);
        return ResponseEntity.ok(service.reservarSala(id, data));
    } catch (Exception e) {
        e.printStackTrace(); // ← Mostra o erro exato
        return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
    }
}
    public class ReservaRequest {
    private Long salaId;
    
    public ReservaRequest(Long salaId) {
        this.salaId = salaId;
    }
    
    // Getters e Setters
    public Long getSalaId() {
        return salaId;
    }
    
    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }
}

}