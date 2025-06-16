package com.gateway;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventoReservaConsumer {

    @RabbitListener(queues = "evento.reserva.criada")
    public void processarMensagemDeReserva(String payload) {
        exibirMensagemRecebida(payload);
    }

    private void exibirMensagemRecebida(String mensagem) {
        System.out.println("[Gateway] Nova reserva recebida: " + mensagem);
    }
}
