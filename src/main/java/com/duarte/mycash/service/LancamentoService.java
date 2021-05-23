package com.duarte.mycash.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duarte.mycash.domain.Lancamento;
import com.duarte.mycash.repository.LancamentoRepository;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    public List<Lancamento> todos(){

        return repository.findAll();
    }

    public Lancamento apenasUm(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public Lancamento criar(Lancamento lancamento) {

        return repository.save(lancamento);
    }

    public Lancamento editar(Integer id, Lancamento novoLancamento) {

        return repository.findById(id).map(lancamento -> {
            lancamento.setDescricao(novoLancamento.getDescricao());
            lancamento.setValor(novoLancamento.getValor());
            lancamento.setData(novoLancamento.getData());
            lancamento.setTipo(novoLancamento.getTipo());

            return repository.save(lancamento);
        }).orElseThrow(() -> new EntityNotFoundException());
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

}
