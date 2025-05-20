package br.com.alura.codechella.application.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.infra.percistense.UsuarioEntity;
import br.com.alura.codechella.application.infra.percistense.UsuarioRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {
    
    private final UsuarioRepository repository;
    private final UsuarioEntityMapper mapper;
    
    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    
    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repository.save(entity);
        return mapper.toDomain(entity);
    }
    
    @Override
    public List<Usuario> listarTodos() {
        return null;
    }
}
