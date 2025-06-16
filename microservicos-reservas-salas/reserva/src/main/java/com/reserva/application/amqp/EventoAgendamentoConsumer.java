package com.reserva.application.amqp;

import com.reserva.domain.model.Agendamento;
import com.reserva.infrastructure.repository.AgendamentoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoAgendamentoConsumer {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @RabbitListener(queues = "evento.agendamento.criado")
    public void processarEventoDeCriacao(String payload) {
        try {
            String[] dados = payload.split(",");
            Long idPessoa = Long.parseLong(dados[0].trim());
            Long idAmbiente = Long.parseLong(dados[1].trim());

            Agendamento novoAgendamento = new Agendamento();
            novoAgendamento.setPessoaId(idPessoa);
            novoAgendamento.setAmbienteId(idAmbiente);

            agendamentoRepository.save(novoAgendamento);

            System.out.println(
                    "[Agendamento] Novo agendamento recebido: Pessoa " + idPessoa + ", Ambiente " + idAmbiente);
        } catch (Exception ex) {
            System.err.println("[Agendamento] Falha ao processar evento: " + payload);
            ex.printStackTrace(); // Adicione isso para ver o erro exato
        }
    }
}
