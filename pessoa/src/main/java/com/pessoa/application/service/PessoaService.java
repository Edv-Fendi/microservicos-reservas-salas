package com.usuario.application.service;

import com.usuario.domain.model.Pessoa;
import com.usuario.infrastructure.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repositorio;

    public List<Pessoa> buscarTodas() {
        return repositorio.findAll();
    }

    public Pessoa registrar(Pessoa pessoa) {
        return repositorio.save(pessoa);
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    public Optional<Pessoa> buscarPorEmail(String email) {
        return repositorio.findByEmail(email);
    }
}
