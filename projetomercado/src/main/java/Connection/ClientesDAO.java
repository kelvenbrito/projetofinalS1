package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;

public class ClientesDAO {
    // atributo
    private Connection connection;
    private List<Cliente> clientes;

    // construtor
    public ClientesDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes_noite (nome VARCHAR(255), cpf VARCHAR(255) PRIMARY KEY)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de clientes criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de clientes: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Cadastrar Carro no banco
    public void cadastrar(String nome, String cpf) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO clientes_noite (nome, cpf)VALUES (?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // // Apagar dados do banco
    // public void apagar(String idSerial) {
    //     PreparedStatement stmt = null;
    //     // Define a instrução SQL parametrizada para apagar dados pela placa
    //     String sql = "DELETE FROM vendas_noite WHERE idSerial = ?";
    //     try {
    //         stmt = connection.prepareStatement(sql);
    //         stmt.setString(1, idSerial);
    //         stmt.executeUpdate(); // Executa a instrução SQL
    //         System.out.println("Dado apagado com sucesso");
    //     } catch (SQLException e) {
    //         throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
    //     } finally {
    //         ConnectionFactory.closeConnection(connection, stmt);
    //     }
    // }
}
