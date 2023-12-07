package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.VendasDAO;
import Model.Vendas;

public class VendasControl {
    // Atributos
    private List<Vendas> vendas;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel, JTable table) {
        this.vendas = vendas;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Métodos do modelo CRUD
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendasDAO().listarTodos();
        // Obtém os vendas atualizados do banco de dados
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada venda como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getIdSerial(), venda.getCpf(),

                    venda.getDataHora(), venda.getTotalCompra() });
        }
    }

    // Método para cadastrar uma nova venda no banco de dados
    public void cadastrar(String cpf, String dataHora, String totalCompra) {
        // Chama o método de cadastro no banco de dados
        new VendasDAO().cadastrar(cpf, dataHora, totalCompra);
        // Atualiza a tabela de exibição após o cadastro
        atualizarTabela();
        // Mensagem confirmando o cadastro
        JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso.");
    }

    // Método para apagar uma venda do banco de dados
    public void apagar(String idSerial) {

        // Chama o método de exclusão no banco de dados
        new VendasDAO().apagar(idSerial);
        // Atualiza a tabela de exibição após a exclusão
        atualizarTabela();
        // Mensagem confirmando o edição
        JOptionPane.showMessageDialog(null, "Venda apagada com sucesso.");
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