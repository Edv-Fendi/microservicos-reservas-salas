package com.reserva.application.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private Long identificador;
    private String nomeCompleto;
    private String email;
    private String telefone;
    private String logradouro;
    private String numeroResidencia;
    private String cidade;
    private String codigoPostal;
    private String documentoCpf;
    private LocalDate nascimento;
    private LocalDate cadastro;
}
