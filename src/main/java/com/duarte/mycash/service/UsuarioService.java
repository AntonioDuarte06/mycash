package com.duarte.mycash.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.duarte.mycash.domain.Usuario;
import com.duarte.mycash.domain.UsuarioRole;
import com.duarte.mycash.exception.UsuarioException;
import com.duarte.mycash.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registraUsuarioAdmin(String email, String senha) {

        if (repo.findByEmail(email).isEmpty()) {

            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(passwordEncoder.encode(senha));
            usuario.setRole(UsuarioRole.ROLE_ADMIN);

            repo.save(usuario);
        }
    }

    public List<Usuario> buscaTodos() {

        return repo.findAll();
    }

    public Usuario buscaPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public Usuario save(String email, String senha) {

        if (repo.findByEmail(email).isPresent())
            throw new UsuarioException("Já existe um usuario com esse email");

        Usuario usuario = new Usuario();

        usuario.setEmail(email);
        usuario.setSenha(passwordEncoder.encode(senha));
        usuario.setRole(UsuarioRole.ROLE_USER);

        return repo.save(usuario);
    }

    public Usuario findByEmail(String email) {

        return repo.findByEmail(email)
                .orElseThrow(() -> new UsuarioException("Usuário não encontrado."));
    }

    public Usuario resetarSenha(String email, String senha) {
        Usuario usuario = findByEmail(email);
        usuario.setSenha(passwordEncoder.encode(senha));

        return repo.save(usuario);
    }

}
