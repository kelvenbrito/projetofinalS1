package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ProdutosDAO;
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



    // Método para cadastrar uma nova venda no banco de dados
    public void cadastrar(String cpf, String totalCompra, String dataHora) {
        // Chama o método de cadastro no banco de dados
        new VendasDAO().cadastrar(cpf, totalCompra, dataHora);

        // Mensagem confirmando o cadastro
        JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso.");
    }

    // Método para apagar uma venda do banco de dados
    public void apagar(String idSerial) {

        // Chama o método de exclusão no banco de dados
        new VendasDAO().apagar(idSerial);

        // Mensagem confirmando o edição
        JOptionPane.showMessageDialog(null, "Venda apagada com sucesso.");
    }

    // Método para atualizar os dados de um carro no banco de dados

    public void vender(String codigoBarra, int quantidade) {

   

         try {

        
                // Chama o método de atualização no banco de dados
                new VendasDAO().vender(codigoBarra, quantidade);
                // Mensagem confirmando a edição
          
        }

        catch (NumberFormatException e) {
            // Tratamento de erro
            e.printStackTrace();
        }

    }

}
