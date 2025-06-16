package com.usuario.infrastructure.controller;

import com.usuario.application.service.PessoaService;
import com.usuario.domain.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService servico;

    @GetMapping
    public List<Pessoa> buscarTodas() {
        return servico.buscarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> buscarPorId(@PathVariable Long id) {
        return servico.buscarPorId(id);
    }

    @PostMapping("/registrar")
    public Pessoa registrar(@RequestBody Pessoa pessoa) {
        try {
            return servico.registrar(pessoa);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao registrar pessoa: email duplicado ou dados inválidos.");
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao registrar pessoa.");
        }
    }
}
