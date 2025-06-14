package com.reservaservice.demo.infrastructure.repository;

import com.reservaservice.demo.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {}