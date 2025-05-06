package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UsuarioTest {
    @Test
    void deveLancarExcecaoParaCpfInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(
                "123456789-99",
                "Bruno",
                LocalDate.parse("1982-03-30"),
                "email@email.com"
            );
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(
                "123456.789-99",
                "Bruno",
                LocalDate.parse("1982-03-30"),
                "email@email.com"
            );
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(
                "12345678999",
                "Bruno",
                LocalDate.parse("1982-03-30"),
                "email@email.com"
            );
        });
    }
    
    @Test
    void naoDeveCriarUsuarioComUsuarioBuilder() {
        UsuarioBuilder usuarioBuilder = new UsuarioBuilder();
        Usuario usuario = usuarioBuilder.comCpfNomeNascimento("096.956.167-98", "Talita", LocalDate.parse("1988-02-29"));
        assertEquals(usuario.getNome(), "Talita");
        
        usuario = usuarioBuilder.incluiEndereco("12345-000", 1708, "apto 34");
        assertEquals(usuario.getEndereco().getComplemento(), "apto 34");
    }
}