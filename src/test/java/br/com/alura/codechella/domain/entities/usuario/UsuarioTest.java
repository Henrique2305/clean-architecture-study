package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99",
                        "Jaque",
                        LocalDate.parse("1990-09-08"),
                        "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678999",
                        "Jaque",
                        LocalDate.parse("1990-09-08"),
                        "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("",
                        "Jaque",
                        LocalDate.parse("1990-09-08"),
                        "email@email.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();

        Usuario usuario = fabrica.comNomeCpfNascimento("Emily", "654.123.897-88",
                LocalDate.parse("2000-10-01"));

        Assertions.assertEquals("Emily", usuario.getNome());

        usuario = fabrica.incluirEndereco("12345-999", 40, "apt 201");

        Assertions.assertEquals("apt 201", usuario.getEndereco().getComplemento());
    }

}