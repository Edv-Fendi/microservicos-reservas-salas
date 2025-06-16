package com.reserva.infrastructure.controller;

import com.reserva.application.dto.DadosAgendamentoDTO;
import com.reserva.application.service.AgendamentoService;
import com.reserva.domain.model.Agendamento;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService servico;

    @Autowired
    private AmqpTemplate mensageiro;

    @GetMapping
    public List<Agendamento> buscarTodos() {
        return servico.obterTodos();
    }

    @GetMapping("/detalhes/{id}")
    public DadosAgendamentoDTO buscarDetalhes(@PathVariable Long id) {
        return servico.buscarDetalhesPorId(id);
    }

    @PostMapping("/registrar")
    public Agendamento registrarAgendamento(@RequestBody Agendamento novoAgendamento) {
        return servico.registrar(novoAgendamento);
    }

    @PostMapping("/registrar-com-evento")
    public void registrarComEvento(@RequestParam Long pessoa, @RequestParam Long ambiente) {
        String payload = pessoa + "," + ambiente;
        mensageiro.convertAndSend("evento.agendamento.criado", payload);
    }

}
