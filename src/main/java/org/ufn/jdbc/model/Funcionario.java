package org.ufn.jdbc.model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Funcionario {
    
    private final DB database = new DB();
    
    private final Integer id;
    private String nome;
    private String cargo;
    private Integer salario;

    private Integer departamento_id;
    public Funcionario(Integer id){
        this.id = id;
        this.nome = this.getNome();
        this.cargo = this.getCargo();
        this.departamento_id = this.getDepartamentoId();
        this.salario = this.getSalario();
    }
    
    public Integer getId(){
        return this.id;
    }

    public String getNome() {
        String SQL = "SELECT funcionario_nome FROM tb_funcionario WHERE funcionario_id = " + this.getId();
        String nome = "";

        try (Connection conn = this.database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            nome = rs.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return nome;
    }

    public void setNome(String nome) {
        System.out.println("\n*** Alterando Nome do Funcionário ***");
        String SQL = "UPDATE tb_funcionario SET funcionario_nome = '" + nome + "' WHERE funcionario_id = " + this.getId();
        try (Connection conn = this.database.connect();
             Statement stmt = conn.createStatement()) {
            int rowCount = stmt.executeUpdate(SQL);
            if (rowCount > 0) {
                System.out.println("Nome atualizado com sucesso!");
                this.nome = nome;
            } else {
                System.out.println("Falha ao atualizar o nome do funcionário.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getCargo() {
        String SQL = "SELECT cargo FROM tb_funcionario WHERE funcionario_id = " + this.getId();
        String cargo = "";

        try (Connection conn = this.database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            cargo = rs.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cargo;
    }

    public void setCargo(String cargo) {
        System.out.println("\n*** Alterando Cargo do Funcionário ***");
        String SQL = "UPDATE tb_funcionario SET cargo = '" + cargo + "' WHERE funcionario_id = " + this.getId();
        try (Connection conn = this.database.connect();
             Statement stmt = conn.createStatement()) {
            int rowCount = stmt.executeUpdate(SQL);
            if (rowCount > 0) {
                System.out.println("Cargo atualizado com sucesso!");
                this.cargo = cargo;
            } else {
                System.out.println("Falha ao atualizar o cargo do funcionário.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer getSalario() {
        String SQL = "SELECT salario FROM tb_funcionario WHERE funcionario_id = " + this.getId();
        Integer salario = 0;

        try (Connection conn = this.database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            salario = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return salario;
    }

    public void setSalario(Integer salario) {
        System.out.println("\n*** Alterando Salário do Funcionário ***");
        String SQL = "UPDATE tb_funcionario SET salario = " + salario + " WHERE funcionario_id = " + this.getId();
        try (Connection conn = this.database.connect();
             Statement stmt = conn.createStatement()) {
            int rowCount = stmt.executeUpdate(SQL);
            if (rowCount > 0) {
                System.out.println("Salário atualizado com sucesso!");
                this.salario = salario;
            } else {
                System.out.println("Falha ao atualizar o salário do funcionário.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /* DEPTO */

    public Integer getDepartamentoId() {
        String SQL = "SELECT departamento_id FROM tb_funcionario WHERE funcionario_id = " + this.getId();
        Integer departamento_id = 0;

        try (Connection conn = this.database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            departamento_id = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return departamento_id;
    }

    public String getDepartamentoNome() {
        String SQL = "SELECT departamento_nome FROM tb_departamento WHERE departamento_id = " + this.getDepartamentoId();
        String nome = "";

        try (Connection conn = this.database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            nome = rs.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return nome;
    }

    public void setDepartamento(Integer departamento_id) {
        System.out.println("\n*** Alterando Departamento do Funcionário ***");
        String SQL = "UPDATE tb_funcionario SET departamento_id = " + departamento_id + " WHERE funcionario_id = " + this.getId();
        try (Connection conn = this.database.connect();
             Statement stmt = conn.createStatement()) {
            int rowCount = stmt.executeUpdate(SQL);
            if (rowCount > 0) {
                System.out.println("Departamento atualizado com sucesso!");
                this.departamento_id = departamento_id;
            } else {
                System.out.println("Falha ao atualizar o departamento do funcionário.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

