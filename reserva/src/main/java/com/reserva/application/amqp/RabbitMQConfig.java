package com.reserva.application.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_AGENDAMENTO_CRIADO = "evento.agendamento.criado";

    @Bean
    public Queue filaAgendamentoCriado() {
        return new Queue(FILA_AGENDAMENTO_CRIADO, true);
    }
}
