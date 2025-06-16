package com.reserva.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reserva.domain.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {}
