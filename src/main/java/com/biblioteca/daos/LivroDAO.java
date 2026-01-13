package com.biblioteca.daos;

import com.biblioteca.models.LivroModel;

import java.util.List;

public interface LivroDAO {
    void create(LivroModel livroModel);
        LivroModel buscarLivroId(int id);
        List<LivroModel> buscarLivro();
        void setDisponivel(int id, boolean disponivel);
}
