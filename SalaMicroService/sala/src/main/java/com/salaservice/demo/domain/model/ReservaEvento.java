package com.salaservice.demo.domain.model;

import java.time.LocalDateTime;

public class ReservaEvento {
    private Long salaId;
    private LocalDateTime dataReserva;

    // Construtor
    public ReservaEvento(Long salaId, LocalDateTime dataReserva) {
        this.salaId = salaId;
        this.dataReserva = dataReserva;
    }

    // Getters e Setters
    public Long getSalaId() {
        return salaId;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }
}