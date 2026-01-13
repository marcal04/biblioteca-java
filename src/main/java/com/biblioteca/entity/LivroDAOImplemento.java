package com.biblioteca.entity;

import com.biblioteca.daos.LivroDAO;
import com.biblioteca.factorys.ConnectionFactory;
import com.biblioteca.models.LivroModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImplemento implements LivroDAO {
    @Override
    public void create(LivroModel livroModel) {
        String sql = "INSERT INTO livro (titulo, ano, disponivel, autor_id) VALUE (?,?,?,?)";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, livroModel.getTitulo());
            ps.setInt(2, livroModel.getAno());
            ps.setBoolean(3, livroModel.isDisponivel());
            ps.setInt(4, livroModel.getAutorId());
            ps.executeUpdate();
            System.out.println("Livro cadastrado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public LivroModel buscarLivroId(int id) {
        String sql = "SELECT * FROM livro WHERE id = ?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return LivroModel.builder()
                        .id(rs.getInt("id"))
                        .titulo(rs.getString("titulo"))
                        .ano(rs.getInt("ano"))
                        .disponivel(rs.getBoolean("disponivel"))
                        .autorId(rs.getInt("autor_id"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar livro", e);
        }
        throw new RuntimeException("Livro não encontrado!");
    }



    @Override
    public List<LivroModel> buscarLivro() {
        List<LivroModel> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                livros.add(new LivroModel(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getInt("ano"),
                        rs.getBoolean("disponivel"),
                        rs.getInt("autor_id")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar livros", e);
        }
        return livros;
    }



    @Override
    public void setDisponivel(int id, boolean disponivel) {
        String sql = "UPDATE livros SET disponivel=? WHERE id=?";
        try (Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setBoolean(1, disponivel);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Disponivel atualizado!");
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
