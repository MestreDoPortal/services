package com.reservaservice.demo.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long salaId;
    private LocalDateTime dataReserva;
    private String status;
    
    // Comportamento de domínio
    public void confirmar() {
        this.status = "CONFIRMADA";
    }
    
    public void cancelar() {
        this.status = "CANCELADA";
    }
}


