package com.reserva.application.dto;

import java.time.LocalDateTime;
import com.reserva.domain.model.Agendamento;
import lombok.Data;

@Data
public class DadosAgendamentoDTO {
    private Long identificador;
    private LocalDateTime horarioAgendado;
    private PessoaDTO participante;
    private AmbienteDTO espaco;

    public DadosAgendamentoDTO(Agendamento agendamento, PessoaDTO participante, AmbienteDTO espaco) {
        this.identificador = agendamento.getIdentificador();
        this.horarioAgendado = agendamento.getMomento();
        this.participante = participante;
        this.espaco = espaco;
    }
}
