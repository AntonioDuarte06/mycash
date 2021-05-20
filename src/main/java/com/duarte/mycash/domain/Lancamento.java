package com.duarte.mycash.domain;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ds_lancamento")
    @NotBlank(message = "Descrição obrigatória.")
    private String descricao;

    @Column(name = "vl_lancamento", precision = 8, scale = 2)
    @Min(value = 100, message = "Campo \"Valor\" deve ser maior ou igual a zero")
    private Double valor;

    @Column(name = "dt_lancamento")
    @FutureOrPresent(message = "Somente datas igual ou superior a hoje.")
    @NotNull(message = "É obrigatório inserir uma data!")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo \"Tipo\" é obrigatório!")
    private LancamentoTipo tipo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LancamentoTipo getTipo() {
        return tipo;
    }

    public void setTipo(LancamentoTipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lancamento other = (Lancamento) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (tipo != other.tipo)
            return false;
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        return true;
    }
}
