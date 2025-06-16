package com.usuario.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;

    private String nomeCompleto;
    private String email;
    private String senha;
    private String telefone;
    private String enderecoRua;
    private String enderecoNumero;
    private String cidade;
    private String codigoPostal;
    private String documentoIdentidade;

    private LocalDate nascimento;
    private LocalDate criadoEm;

    public void setNomeCompleto(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException("Nome deve ter pelo menos 3 caracteres.");
        }
        this.nomeCompleto = nome;
    }

    public void setDocumentoIdentidade(String doc) {
        if (!isCpfValido(doc)) {
            throw new IllegalArgumentException("Documento de identidade inválido.");
        }
        this.documentoIdentidade = doc;
    }

    private boolean isCpfValido(String cpf) {
        return Pattern.matches("\\d{11}", cpf);
    }
}
