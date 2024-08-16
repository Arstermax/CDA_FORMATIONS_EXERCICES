package org.example.todo_back.utils;

import org.springframework.security.core.GrantedAuthority;

public enum EtatTodos implements GrantedAuthority {
    PasCommencer,
    Encours,
    Annule,
    Terminer;

    @Override
    public String getAuthority() {
        return name();
    }
}
