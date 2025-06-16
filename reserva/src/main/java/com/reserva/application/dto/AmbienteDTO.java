package com.reserva.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmbienteDTO {
    private Long identificador;
    private String nome;
    private Integer capacidade;
    private String localizacao;
}
