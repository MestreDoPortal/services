package com.reservaservice.demo.application.service;

import com.reservaservice.demo.domain.model.Reserva;
import com.reservaservice.demo.domain.model.ReservaEvento;
import com.reservaservice.demo.infrastructure.repository.ReservaRepository;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    public List<Reserva> listar() {
        return repository.findAll();
    }

    public Reserva salvar(Reserva reserva) {
        return repository.save(reserva);
    }
    
    @RabbitListener(queues = "reserva.queue")
    @Transactional
    public void processarReserva(ReservaEvento evento) {
        Reserva reserva = new Reserva();
        reserva.setSalaId(evento.getSalaId());
        reserva.setDataReserva(evento.getDataReserva());
        reserva.setStatus("PENDENTE");
        repository.save(reserva);
    }
}

