package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.application.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.application.infra.percistense.UsuarioRepository;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario(repositorioDeUsuario);
    }
    
    @Bean
    RepositorioDeUsuarioJpa criarRepositorioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper) {
        return new RepositorioDeUsuarioJpa(repositorio, mapper);
    }
    
    @Bean
    UsuarioEntityMapper criarMapper() {
        return new UsuarioEntityMapper();
    }
}
