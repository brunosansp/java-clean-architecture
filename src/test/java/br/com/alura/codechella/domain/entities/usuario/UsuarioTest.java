package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
    }
}