package com.biblioteca.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmprestimoModel {
    private int id;
    private int livro_id;
    private int usuario_id;
    private Date data_do_emprestimo;
    private Date data_de_retorno;
}
