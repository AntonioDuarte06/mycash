package com.duarte.mycash.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duarte.mycash.domain.Usuario;
import com.duarte.mycash.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> buscaTodos(){
        return service.buscaTodos();
    }

    @PostMapping
    public Usuario criar(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String senha) {

        return service.save(email, senha);
    }

    @GetMapping("/{email}")
    public Usuario apenasUm(@PathVariable("email") String email) {
        return service.findByEmail(email);
    }

    @PutMapping("/{email}")
    public Usuario resetarSenha(
            @PathVariable("email") String email,
            @RequestParam(required = true) String senhaNova) {
        return service.resetarSenha(email, senhaNova);
    }

}
