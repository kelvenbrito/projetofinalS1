package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ProdutosDAO;
import Model.Produtos;

public class ProdutosControl {
     // Atributos
    private List<Produtos> produtos;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public ProdutosControl(List<Produtos> produtos, DefaultTableModel tableModel, JTable table) {
        this.produtos = produtos;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Métodos do modelo CRUD
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        produtos = new ProdutosDAO().listarTodos();
        // Obtém os produtos atualizados do banco de dados
        for (Produtos produto : produtos) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { produto.getCodigoBarra(), produto.getNome(),

                    produto.getPreco(), produto.getQuantidade() });
        }
    }

    // Método para cadastrar um novo carro no banco de dados
    public void cadastrar(String codigoBarra, String nome, String preco, String quantidade) {
        // Chama o método de cadastro no banco de dados
        new ProdutosDAO().cadastrar(codigoBarra, nome, preco, quantidade);
        // Atualiza a tabela de exibição após o cadastro
        atualizarTabela();
        // Mensagem confirmando o cadastro
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
    }

    // Método para atualizar os dados de um carro no banco de dados
    public void atualizar(String codigoBarra, String nome, String preco, String quantidade) {
        // Chama o método de atualização no banco de dados
        new ProdutosDAO().atualizar(codigoBarra, nome, preco, quantidade);
        // Atualiza a tabela de exibição após a atualização
        atualizarTabela();
        // Mensagem confirmando o edição
        JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.");
    }

    // Método para apagar um carro do banco de dados
    public void apagar(String codigoBarra) {

        // Chama o método de exclusão no banco de dados
        new ProdutosDAO().apagar(codigoBarra);
        // Atualiza a tabela de exibição após a exclusão
        atualizarTabela();
        // Mensagem confirmando o edição
        JOptionPane.showMessageDialog(null, "Produto apagado com sucesso.");
    }

    // ======================Validação de Dados==========================
    // Método interno para validação de dados númericos
    // private boolean ApenasNumeros(String string) {
    //     return string.matches("\\d*"); // Verifica se a string contém apenas dígitos
    // }

    // public boolean ApenasLetras(String texto) {
    //     return texto.matches("[a-zA-Z]+"); // Verifica se a string contém apenenas letras e/ou caracteres especiais
    // }
}
