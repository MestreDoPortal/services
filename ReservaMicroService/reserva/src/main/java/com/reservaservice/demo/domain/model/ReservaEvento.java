package com.reservaservice.demo.domain.model;

import java.time.LocalDateTime;

public class ReservaEvento {
    private Long salaId;
    private LocalDateTime dataReserva;
    
    // Getters e Setters
    public Long getSalaId() {
        return salaId;
    }
    
    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }
    
    public LocalDateTime getDataReserva() {
        return dataReserva;
    }
    
    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }
}