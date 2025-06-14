package com.salaservice.demo.application.service;

import com.salaservice.demo.domain.model.Sala;
import com.salaservice.demo.domain.model.ReservaEvento;
import com.salaservice.demo.infrastructure.repository.SalaRepository;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalaService {
    private final SalaRepository repository;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public SalaService(SalaRepository repository, RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.rabbitTemplate = rabbitTemplate;
    }

@Transactional
public Sala reservarSala(Long id, LocalDateTime dataReserva) {
    Sala sala = repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada"));
    
    if (!sala.isDisponivel()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sala já reservada");
    }
    
    sala.reservar();
    repository.save(sala);
    
    try {
        rabbitTemplate.convertAndSend(
            "reserva.exchange",
            "reserva.nova",
            new ReservaEvento(id, dataReserva));
    } catch (AmqpException e) {
        // Compensação em caso de falha
        sala.liberar();
        repository.save(sala);
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Erro ao processar reserva");
    }
    
    return sala;
}

    public List<Sala> listar() {
        return repository.findAll();
    }

    public Sala salvar(Sala sala) {
        return repository.save(sala);
    }
}