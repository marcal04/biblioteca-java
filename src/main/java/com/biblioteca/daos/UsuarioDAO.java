package com.biblioteca.daos;

import com.biblioteca.models.UsuarioModel;

import java.util.List;

public interface UsuarioDAO {
    void create(UsuarioModel usuarioModel);
    UsuarioModel buscarUsuarioId(int id);
    List<UsuarioModel> buscarUsuario();

}
