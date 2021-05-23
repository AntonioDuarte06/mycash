package com.duarte.mycash.web.api;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duarte.mycash.domain.Lancamento;
import com.duarte.mycash.service.LancamentoService;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService service;

    @GetMapping
    public Page<Lancamento> todos(Pageable pageable) {
        return service.todos(pageable);
    }

    @GetMapping("/{id}")
    public Lancamento apenasUm(@PathVariable("id") Integer id) {
        return service.apenasUm(id);
    }

    @PostMapping
    public Lancamento criar(@Valid @RequestBody Lancamento lancamento) {
        return service.criar(lancamento);
    }

    @PutMapping("/{id}")
    public Lancamento editar(@PathVariable Integer id, @RequestBody Lancamento novoLancamento) {
        return service.editar(id, novoLancamento);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }

}
