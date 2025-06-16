package com.sala.application.service;

import com.sala.domain.model.EspacoFisico;
import com.sala.infrastructure.repository.EspacoFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacoFisicoService {

    @Autowired
    private EspacoFisicoRepository repositorio;

    public List<EspacoFisico> buscarTodos() {
        return repositorio.findAll();
    }

    public EspacoFisico buscarPorId(Long idEspaco) {
        return repositorio.findById(idEspaco)
                .orElseThrow(() -> new RuntimeException("Espaço físico não encontrado"));
    }

    public EspacoFisico registrar(EspacoFisico espaco) {
        return repositorio.save(espaco);
    }
}
