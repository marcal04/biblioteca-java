package com.biblioteca.services;

import com.biblioteca.daos.AutorDAO;
import com.biblioteca.entity.AutorDAOImplemento;
import com.biblioteca.models.AutorModel;

    public class AutorService {

        private final AutorDAO dao = new AutorDAOImplemento();

        public void cadastrar(String nome) {
            if (nome == null || nome.isBlank()) {
                throw new IllegalArgumentException("Nome do autor é obrigatório");
            }

            dao.create(
                    AutorModel.builder()
                            .nome(nome)
                            .build()
            );
        }

        public void listar() {
            dao.buscarAutor().forEach(System.out::println);
        }
    }


