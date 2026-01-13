package com.biblioteca.entity;

import com.biblioteca.daos.UsuarioDAO;
import com.biblioteca.factorys.ConnectionFactory;
import com.biblioteca.models.UsuarioModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImplemento implements UsuarioDAO {

    @Override
    public void create(UsuarioModel usuarioModel) {
        String sql = "INSERT INTO usuario (nome, email) VALUES (?, ?)";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, usuarioModel.getNome());
            ps.setString(2, usuarioModel.getEmail());
            ps.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("Usuário já cadastrado com esse email");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário", e);
        }
    }

    @Override
    public UsuarioModel buscarUsuarioId(int id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return UsuarioModel.builder()
                        .id(rs.getInt("id"))
                        .nome(rs.getString("nome"))
                        .email(rs.getString("email"))
                        .build();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário", e);
        }

        throw new RuntimeException("Usuário não encontrado!");
    }

    @Override
    public List<UsuarioModel> buscarUsuario() {
        String sql = "SELECT * FROM usuario";
        List<UsuarioModel> usuarios = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                usuarios.add(
                        UsuarioModel.builder()
                                .id(rs.getInt("id"))
                                .nome(rs.getString("nome"))
                                .email(rs.getString("email"))
                                .build()
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários", e);
        }

        return usuarios;
    }
}
