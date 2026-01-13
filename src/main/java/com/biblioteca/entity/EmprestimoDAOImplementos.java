package com.biblioteca.entity;

import com.biblioteca.daos.EmprestimoDAO;
import com.biblioteca.factorys.ConnectionFactory;
import com.biblioteca.models.EmprestimoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAOImplementos implements EmprestimoDAO {


    @Override
    public void create(EmprestimoModel emprestimoModel) {
        String sql = "INSERT INTO emprestimo (livro_id, usuario_id, data_do_emprestimo) VALUES (?, ?, ?)";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, emprestimoModel.getLivro_id());
            ps.setInt(2, emprestimoModel.getUsuario_id());
            ps.setDate(3, new java.sql.Date(
                    emprestimoModel.getData_do_emprestimo().getTime()
            ));

            ps.executeUpdate();
            System.out.println("Empréstimo registrado!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar empréstimo", e);
        }
    }


    @Override
    public List<EmprestimoModel> buscarEmprestimo() {
        List<EmprestimoModel> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM emprestimo";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                emprestimos.add(
                        EmprestimoModel.builder()
                                .id(rs.getInt("id"))
                                .livro_id(rs.getInt("livro_id"))
                                .usuario_id(rs.getInt("usuario_id"))
                                .data_do_emprestimo(rs.getDate("data_do_emprestimo"))
                                .data_de_retorno(rs.getDate("data_do_retorno"))
                                .build()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar empréstimos", e);
        }
        return emprestimos;
    }
}
