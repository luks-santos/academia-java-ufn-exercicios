package org.ufn.jbdc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Funcionario {

    private Integer id;
    private String nome;
    private String cargo;
    private Integer departamento_id;
    private Integer salario;

    public Funcionario(Integer id) {
        this.id = id;
        this.nome = this.getNome();
        this.cargo = this.getCargo();
        this.departamento_id = this.getDepartamentoId();
        this.salario = this.getSalario();
    }

    public Funcionario(String nome, String cargo, Integer departamento_id, Integer salario) throws SQLException {

        String insertSQL = "INSERT INTO tb_funcionario (funcionario_nome, cargo, departamento_id, salario) VALUES (?, ?, ?, ?)";
        Connection conn = DB.connect(false);

        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, cargo);
            pstmt.setInt(3, departamento_id);
            pstmt.setInt(4, salario);

            pstmt.executeUpdate();
            conn.commit();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                this.id = generatedKeys.getInt(1);
                this.nome = nome;
                this.cargo = cargo;
                this.departamento_id = departamento_id;
                this.salario = salario;
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
        String selectSQL = "SELECT funcionario_nome FROM tb_funcionario WHERE funcionario_id = (?)";
        String nome = "";

        try (Connection conn = DB.connect(true);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, this.getId());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    nome = rs.getString(1);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return nome;
    }

    public void setNome(String nome) {
        String updateSQL = "UPDATE tb_funcionario SET funcionario_nome = ? WHERE funcionario_id = ?";

        try (Connection conn = DB.connect(false);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setString(1, nome);
            pstmt.setInt(2, this.getId());
            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            handleSQLException(e);
        }
        this.nome = nome;
    }

    public String getCargo() {
        String selectSQL = "SELECT cargo FROM tb_funcionario WHERE funcionario_id = ?";
        String cargo = "";

        try (Connection conn = DB.connect(true);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, this.getId());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cargo = rs.getString(1);
                }
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }
        return cargo;
    }

    public void setCargo(String cargo) {
        String updateSQL = "UPDATE tb_funcionario SET cargo = ? WHERE funcionario_id = (?)";
        try (Connection conn = DB.connect(false);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setString(1, cargo);
            pstmt.setInt(2, this.getId());
            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            handleSQLException(e);
        }
        this.cargo = cargo;
    }

    public Integer getSalario() {
        String selectSQL = "SELECT salario FROM tb_funcionario WHERE funcionario_id = ?";
        Integer salario = 0;

        try (Connection conn = DB.connect(true);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, this.getId());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    salario = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }
        return salario;
    }

    public void setSalario(Integer salario) {
        String updateSQL = "UPDATE tb_funcionario SET salario = ? WHERE funcionario_id = (?)";
        try (Connection conn = DB.connect(false);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setInt(1, salario);
            pstmt.setInt(2, this.getId());
            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            handleSQLException(e);
        }
        this.salario = salario;
    }

    public Integer getDepartamentoId() {
        String selectSQL = "SELECT departamento_id FROM tb_funcionario WHERE funcionario_id = (?)";
        Integer departamento_id = 0;

        try (Connection conn = DB.connect(true);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, this.getId());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    departamento_id = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }
        return departamento_id;
    }

    public String getDepartamentoNome() {
        String selectSQL = "SELECT departamento_nome FROM tb_departamento WHERE departamento_id = ?";
        String nome = "";

        try (Connection conn = DB.connect(true);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, this.getDepartamentoId());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    nome = rs.getString(1);
                }
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }
        return nome;
    }

    public void setDepartamento(Integer departamento_id) {
        String updateSQL = "UPDATE tb_funcionario SET departamento_id = ? WHERE funcionario_id = ?";

        try (Connection conn = DB.connect(false);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setInt(1, departamento_id);
            pstmt.setInt(2, this.getId());
            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            handleSQLException(e);
        }
        this.departamento_id = departamento_id;
    }

    private void handleSQLException(SQLException e) {
        System.out.println("SQL Exception: " + e.getMessage());
    }
}
