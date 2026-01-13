package com.biblioteca.daos;

import com.biblioteca.models.EmprestimoModel;

import java.util.List;
import java.sql.Date;
public interface EmprestimoDAO {
    void create(EmprestimoModel emprestimoModel);
    List<EmprestimoModel> buscarEmprestimo();
}
