package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.time.LocalDate;

public class UsuarioBuilder {
    
    private Usuario usuario;
    
    public static final String EMPTY_EMAIL = "";
    
    public Usuario comCpfNomeNascimento(String cpf, String nome, LocalDate nascimento) {
        this.usuario = new Usuario(cpf, nome, nascimento, EMPTY_EMAIL);
        return this.usuario;
    }
    
    public Usuario incluiEndereco(String cep, Integer numero, String complemento) {
        this.usuario.setEndereco(new Endereco(cep, numero, complemento));
        return this.usuario;
    }
}
