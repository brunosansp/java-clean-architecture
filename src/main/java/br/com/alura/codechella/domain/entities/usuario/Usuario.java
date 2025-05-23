package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    private Endereco endereco;
    
    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))
            throw new IllegalArgumentException("CPF inválido");
        
        int idade = Period.between(nascimento, LocalDate.now()).getYears();
        if (idade < 18)
            throw new IllegalArgumentException("Usuário deve ter pelo menos 18 anos de idade!");
        
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public LocalDate getNascimento() {
        return nascimento;
    }
    
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
