package com.duarte.mycash.web.api;

import java.util.List;
import java.util.stream.Collectors;

import com.duarte.mycash.web.dto.UsuarioDTO;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UsuarioDTO> buscaTodos(){

        List<Usuario> todos = service.buscaTodos();

        List<UsuarioDTO> usuariosDTO = todos.stream().map((usuario) -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());

        return usuariosDTO;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Usuario criar(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String senha) {

        return service.save(email, senha);
    }

    @GetMapping("/{email}")
    @PreAuthorize("#email == authentication.getName() or hasRole('ROLE_ADMIN')")
    public Usuario apenasUm(Authentication authentication, @PathVariable("email") String email) {
        return service.findByEmail(email);
    }

    @PutMapping("/{email}")
    @PreAuthorize("#email == authentication.getName()")
    public Usuario resetarSenha(
            Authentication authentication,
            @PathVariable("email") String email,
            @RequestParam(required = true) String senhaNova) {
        return service.resetarSenha(email, senhaNova);
    }

}
