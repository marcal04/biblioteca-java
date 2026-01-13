package com.biblioteca.entity;

import com.biblioteca.daos.AutorDAO;
import com.biblioteca.factorys.ConnectionFactory;
import com.biblioteca.models.AutorModel;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAOImplemento implements AutorDAO {

    @Override
    public void create(AutorModel autorModel) {
        String sql = "INSERT INTO autor (nome) VALUES (?)";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, autorModel.getNome());
            ps.executeUpdate();

            System.out.println("Autor cadastrado!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar autor", e);
        }
    }



    @Override
    public List<AutorModel> buscarAutor() {
        List<AutorModel> autores = new ArrayList<>();
        String sql = "SELECT * FROM autor";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                autores.add(
                        AutorModel.builder()
                                .id(rs.getInt("id"))
                                .nome(rs.getString("nome"))
                                .build()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar autores", e);
        }

        return autores;
    }

}
