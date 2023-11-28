package View;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CadastroProdutosPainel extends JPanel {
    private JTextField codBarras, nomeProd,precoProd,quantProd;
    private JButton cadastrar, apagar, editar;
      //private List<Carros> carros;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public CadastroProdutosPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro de Produtos"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Código de Barras do Produto"));
        codBarras = new JTextField(20);
        inputPanel.add(codBarras);;
        inputPanel.add(new JLabel("Nome"));
        nomeProd = new JTextField(20);
        inputPanel.add(nomeProd);
        inputPanel.add(new JLabel("Preço"));
        precoProd = new JTextField(20);
        inputPanel.add(precoProd);
        inputPanel.add(new JLabel("Quantidade"));
        quantProd = new JTextField(20);
        inputPanel.add(quantProd);
        add(inputPanel);
         JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        add(botoes);
          // tabela de carros
          JScrollPane jSPane = new JScrollPane();
          add(jSPane);
          tableModel = new DefaultTableModel(new Object[][] {},
                  new String[] { "Códico de Barras", "Nome", "Preço", "Quantidade", "Valor" });
          table = new JTable(tableModel);
          jSPane.setViewportView(table);

    }

}