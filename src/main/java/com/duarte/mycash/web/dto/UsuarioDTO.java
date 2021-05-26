package com.duarte.mycash.web.dto;

import com.duarte.mycash.domain.UsuarioRole;

public class UsuarioDTO {

    private String email;

    private UsuarioRole role;

    public UsuarioRole getRole() {
        return role;
    }

    public void setRole(UsuarioRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
