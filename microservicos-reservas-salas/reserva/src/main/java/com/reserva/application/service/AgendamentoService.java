package com.reserva.application.service;

import com.reserva.application.dto.DadosAgendamentoDTO;
import com.reserva.application.dto.AmbienteDTO;
import com.reserva.application.dto.PessoaDTO;
import com.reserva.domain.model.Agendamento;
import com.reserva.infrastructure.repository.AgendamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repositorio;

    @Autowired
    private RestTemplate clienteHttp;

    public List<Agendamento> obterTodos() {
        return repositorio.findAll();
    }

    public DadosAgendamentoDTO buscarDetalhesPorId(Long idAgendamento) {
        Agendamento agendamento = repositorio.findById(idAgendamento)
            .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        PessoaDTO pessoa = clienteHttp.getForObject(
            "http://usuario:8082/usuarios/" + agendamento.getPessoaId(), PessoaDTO.class);

        AmbienteDTO ambiente = clienteHttp.getForObject(
            "http://sala:8082/salas/" + agendamento.getAmbienteId(), AmbienteDTO.class);

        return new DadosAgendamentoDTO(agendamento, pessoa, ambiente);
    }

    public Agendamento registrar(Agendamento agendamento) {
        return repositorio.save(agendamento);
    }
}
