package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesDAO;
import Model.Clientes;

public class ClientesControl {
    // Atributos
    private List<Clientes> clientes;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public ClientesControl() {
        this.clientes = clientes;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para cadastrar uma nova venda no banco de dados
    public void cadastrar(String cpf, String nome) {
        // Chama o método de cadastro no banco de dados
        new ClientesDAO().cadastrar(cpf, nome);

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
    }

    // Método para apagar uma venda do banco de dados
    public void apagar(String cpf) {

        // Chama o método de exclusão no banco de dados
        new ClientesDAO().apagar(cpf);

        // Mensagem confirmando o edição
        JOptionPane.showMessageDialog(null, "Cliente apagada com sucesso.");
    }

    // ======================Validação de Dados==========================
    // Método interno para validação de dados númericos
    // private boolean ApenasNumeros(String string) {
    // return string.matches("\\d*"); // Verifica se a string contém apenas dígitos
    // }

    // public boolean ApenasLetras(String texto) {
    // return texto.matches("[a-zA-Z]+"); // Verifica se a string contém apenenas
    // letras e/ou caracteres especiais
    // }
}
