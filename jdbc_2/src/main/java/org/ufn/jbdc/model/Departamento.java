package org.ufn.jbdc.model;

import java.sql.*;


public class Departamento {


    private Integer id;
    private String nome;

    public Departamento(Integer id) {
        this.id = id;
        this.nome = this.getNome();
    }

    public Departamento(String nome) throws SQLException {
        this.id = 0;

        String insertSQL = "INSERT INTO tb_departamento (departamento_nome) VALUES (?);";
        Connection conn = DB.connect(false);

        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, nome);
            pstmt.executeUpdate();
            conn.commit();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                this.id = generatedKeys.getInt(1);
                this.nome = nome;
            }
            else {
                throw new SQLException("Erro ao criar departamento, nenhum ID retornado.");
            }

        }
        catch (SQLException e) {
            conn.rollback();
            System.out.println(e.getMessage());
        }
        finally {
            conn.close();
        }
    }

    public Integer getId() {
        return this.id;
    }


    public String getNome() {
        String selectSQL = "SELECT departamento_nome FROM tb_departamento WHERE departamento_id = (?)";
        String nome = "";

        try (Connection conn = DB.connect(true);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, this.getId());

            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                nome = rs.getString("departamento_nome");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return nome;
    }

    public Integer getQuantidadeFuncionarios() {
        String selectSQL = "SELECT COUNT(departamento_id) FROM tb_funcionario WHERE departamento_id = ?";
        Integer count = 0;

        try (Connection conn = DB.connect(true);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, this.getId());

            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void destroy() throws SQLException {
        String deleteSQL = "DELETE FROM tb_departamento WHERE departamento_id = ?;";
        Connection conn = DB.connect(false);

        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, this.getId());
            pstmt.execute();
        } catch (SQLException e) {
            conn.rollback();
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
    }
}
