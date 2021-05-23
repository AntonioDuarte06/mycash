package com.duarte.mycash.web.dto.error;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@JsonInclude(Include.NON_EMPTY) // Não exibe atributos que estiverem vazio
public class ApiError {

    private HttpStatus status;
    private LocalDateTime dataHora;
    private String menssagem;
    private List<String> subErros = new ArrayList<>();

    public ApiError(HttpStatus status) {
        this.status = status;
        this.dataHora = LocalDateTime.now();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    public List<String> getSubErros() {
        return subErros;
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        this.subErros = fieldErrors.stream()
                .map((fe) -> fe.getDefaultMessage())
                .collect(Collectors.toList());

    }


}
