/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DAO;

import br.com.model.jogo;
import br.com.util.Connction;

// Importações do JDBC (Java Database Connectivity)
import java.sql.*;  // quando queremos importar muitas coisas usamos o *

// Importações para trabalhar com listas
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesus
 */
public class jogoDAO {

    // ===========================
    // INSERIR (CREATE)
    // ========================
    public void inserir(jogo j) {
        // Comando SQL para inserir dados no banco
        // ? são parâmetros que serão preenchidos depois
        String sql = "INSERT INTO jogo(titulo, plataforma, preco, imagem_path) VALUES (?, ?, ?, ?)";
        // try-with-resources:
        // Abre a coonexão e fecha automaticamente depois
        try (Connection c = Connction.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            // Define os valores nos ? da query 
            ps.setString(1, j.getTitulos());
            ps.setString(2, j.getPlataforma());
            ps.setDouble(3, j.getPreco());
            ps.setString(4, j.getImagemPath());
            // Executa o INSERT no banco
            ps.executeLargeUpdate();

        } catch (Exception e) {
            // Caso dÊ erro, mostre  a mensagem
            throw new RuntimeException("Erro ao inserir: " + e.getMessage());
        }
    }

    //=========================
    // ATUALIZAR (UPDATE)
    // =======================
    public void atualizar(jogo j) {
        String sql = "UPDATE jogo SET titulo = ?, plataforma = ?, preco = ?, imagem_path = ? WHERE id = ?";

        try (Connection c = Connction.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            // Define os valores nos ? da query 
            ps.setString(1, j.getTitulos());
            ps.setString(2, j.getPlataforma());
            ps.setDouble(3, j.getPreco());
            ps.setString(4, j.getImagemPath());
            // Executa o INSERT no banco
            ps.setInt(5, j.getId());
            ps.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException("Erro ao inserir: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM jogo where id = ?";

        try (Connection c = Connction.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException("Erro ao inserir: " + e.getMessage());
        }
    }

    public List<jogo> listar() throws SQLException {
        List<jogo> lista = new ArrayList<>();
        String sql = "SELET * FROM jogo ORDER BY titulo";

        try (Connection c = Connction.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                // cria um objeto jogo
                jogo j = new jogo();
                // pega dados do banco e coleta no objeto
                j.setId(rs.getInt("id"));
                j.setTitulos(rs.getString("titulo"));
                j.setPlataforma(rs.getString("plataforma"));
                j.setPreco(rs.getDouble("preco"));
                j.setImagemPath(rs.getString("imagem_path"));

            }

        } catch (Exception e) {

            throw new RuntimeException("Erro ao inserir: " + e.getMessage());
        }

        return lista;
    }

    public jogo buscarPorId(int id) 
    {
        String sql = "SELECT * FROM jogo WHERE id = ?";
        try (Connection c = Connction.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ) 
        {
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    jogo j = new jogo();
                    
                    j.setId(rs.getInt("id"));
                    j.setTitulos(rs.getString("titulos"));
                    j.setPreco(rs.getDouble("preco"));
                    j.setPlataforma(rs.getString("plataforma"));
                    j.setPlataforma(rs.getString("imagem_path"));
                    
                    return j;
                }
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException("Erro ao buscar dados: " + e.getMessage());
        }
        return null;
    }
}
