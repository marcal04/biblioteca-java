package com.biblioteca.services;

import com.biblioteca.daos.LivroDAO;
import com.biblioteca.entity.LivroDAOImplemento;
import com.biblioteca.models.LivroModel;

public class LivroService {
    private static final LivroDAO dao = new LivroDAOImplemento();

    public void cadastrar(String titulo, int ano, int autorId){
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo é obrigatorio");
        }

        LivroModel livro = LivroModel.builder()
                .titulo(titulo)
                .ano(ano)
                .autorId(autorId)
                .disponivel(true)
                .build();

        dao.create(livro);
    }

    public void listar(){
        dao.buscarLivro().forEach(System.out::println);
    }

    public static LivroModel buscar(int id){
        return dao.buscarLivroId(id);
    }

    public void marcarDisponivel(int id, boolean disponivel) {
        dao.setDisponivel(id, disponivel);
    }

    }

