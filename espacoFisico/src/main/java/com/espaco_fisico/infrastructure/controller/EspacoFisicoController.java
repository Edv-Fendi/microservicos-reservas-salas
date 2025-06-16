package com.sala.infrastructure.controller;

import com.sala.application.service.EspacoFisicoService;
import com.sala.domain.model.EspacoFisico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espacos")
public class EspacoFisicoController {

    @Autowired
    private EspacoFisicoService servico;

    @GetMapping
    public List<EspacoFisico> listarTodos() {
        return servico.buscarTodos();
    }

    @GetMapping("/{id}")
    public EspacoFisico buscarPorId(@PathVariable Long id) {
        return servico.buscarPorId(id);
    }

    @PostMapping("/registrar")
    public EspacoFisico registrar(@RequestBody EspacoFisico espaco) {
        return servico.registrar(espaco);
    }
}
