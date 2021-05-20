package com.duarte.mycash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duarte.mycash.domain.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {


}
