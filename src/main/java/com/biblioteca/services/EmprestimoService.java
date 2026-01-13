package com.biblioteca.services;

import com.biblioteca.daos.EmprestimoDAO;
import com.biblioteca.entity.EmprestimoDAOImplementos;
import com.biblioteca.models.EmprestimoModel;
import com.biblioteca.models.LivroModel;


import java.util.Date;

public class EmprestimoService {

    private final EmprestimoDAO dao = new EmprestimoDAOImplementos();
    private final LivroService livroService  = new LivroService();
    private final UsuarioService usuarioService  = new UsuarioService();

    public void emprestar(int livroId, int usuarioId) {

        LivroModel livroModel = livroService.buscar(livroId);
        if (!livroModel.isDisponivel()) {
            System.out.println("Livro indisponivel");
            return;
        }

        usuarioService.buscar(usuarioId);

        Date agora = new Date();

        dao.create(
                EmprestimoModel.builder()
                        .livro_id(livroId)
                        .usuario_id(usuarioId)
                        .data_do_emprestimo(agora)
                        .data_de_retorno(null)
                .build());
        livroService.marcarDisponivel(livroId, false);
    }

    public void listar(){
        dao.buscarEmprestimo().forEach(System.out::println);
    }
}
