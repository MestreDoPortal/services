package com.salaservice.demo.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int capacidade;
    private boolean disponivel = true;

    // Método sem parâmetros
    public void reservar() {
        if (!this.disponivel) {
            throw new IllegalStateException("Sala já está reservada");
        }
        this.disponivel = false;
    }

    public void liberar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'liberar'");
    }
}