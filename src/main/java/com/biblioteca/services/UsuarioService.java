package com.biblioteca.services;

import com.biblioteca.daos.UsuarioDAO;
import com.biblioteca.entity.UsuarioDAOImplemento;
import com.biblioteca.models.UsuarioModel;

public class UsuarioService {
    private final UsuarioDAO dao = new UsuarioDAOImplemento();

    public void cadastrar(String nome, String email) {
        UsuarioModel usuario = UsuarioModel.builder()
                .nome(nome)
                .email(email)
                .build();

        dao.create(usuario);
    }

    public void listar() {
        dao.buscarUsuario().forEach(System.out::println);
    }

    public UsuarioModel buscar (int id) {
        return dao.buscarUsuarioId(id);
    }


}