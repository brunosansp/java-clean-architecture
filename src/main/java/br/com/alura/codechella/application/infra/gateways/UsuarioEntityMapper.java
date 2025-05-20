package br.com.alura.codechella.application.infra.gateways;

import br.com.alura.codechella.application.infra.percistense.UsuarioEntity;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class UsuarioEntityMapper {
    
    UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
            usuario.getEmail(),
            usuario.getNascimento(),
            usuario.getNome(),
            usuario.getCpf()
        );
    }
    
    public Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
            entity.getCpf(),
            entity.getNome(),
            entity.getNascimento(),
            entity.getEmail()
        );
    }
}
