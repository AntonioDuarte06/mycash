package com.duarte.mycash.security;


import com.duarte.mycash.domain.Usuario;
import com.duarte.mycash.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDatailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não econtrado"));

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRole().name());
        return new User(usuario.getEmail(), usuario.getSenha(), Arrays.asList(authority));
    }
}
