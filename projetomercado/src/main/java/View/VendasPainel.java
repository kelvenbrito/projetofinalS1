package View;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class VendasPainel extends JPanel {
    // Atributos(componentes)
    private JButton inserirProduto, apagarProduto, editarProduto, finalizarVenda, Teste;
    private JTextField clienteCpfField, codigoProdutoField, quantidadeProdutoField;
    //private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    //
    // Construtor(GUI-JPanel)
    public VendasPainel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Caixa de Vendas"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("CPF"));
        clienteCpfField = new JTextField(20);
        inputPanel.add(clienteCpfField);
        inputPanel.add(new JLabel("Código do Produto"));
        codigoProdutoField = new JTextField(3);
        inputPanel.add(codigoProdutoField);
        inputPanel.add(new JLabel("Quantidade"));
        quantidadeProdutoField = new JTextField(3);
        inputPanel.add(quantidadeProdutoField);
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(inserirProduto = new JButton("Inserir"));
        botoes.add(apagarProduto = new JButton("Editar"));
        botoes.add(finalizarVenda = new JButton("Apagar"));
        add(botoes);
        // tabela de clientes
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Quantidade", "Código", "Preço", "Desconto VIP" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        JPanel teste = new JPanel();
        teste.add(Teste = new JButton("Teste"));
        teste.add(finalizarVenda = new JButton("Finalizar"));
         add(teste);


        // Cria o banco de dados caso não tenha sido criado
        //new ClientesDAO().criaTabela();
        // atualizarTabela();

        // Tratamento de eventos -- dentro construtor
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    clienteCpfField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    codigoProdutoField.setText((String) table.getValueAt(linhaSelecionada, 1));
                }
            }
        });

        //ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);
        // Configura a ação do botão "cadastrar" para adicionar um novo registro no
        // banco de dados

        // Tratamento do botão cadastrar
        // cadastrar.addActionListener(e -> {
        // operacoes.cadastrar(clienteNomeField.getText(),
        // clienteIdadeField.getText(), clienteCPFField.getText());
        // clienteNomeField.setText("");
        // clienteIdadeField.setText("");
        // clienteCPFField.setText("");
        // });

        // // Tratamento do botão editar
        // editar.addActionListener(e -> {
        // operacoes.atualizar(clienteNomeField.getText(),
        // clienteIdadeField.getText(), clienteCPFField.getText());
        // clienteNomeField.setText("");
        // clienteIdadeField.setText("");
        // clienteCPFField.setText("");
        // });

        // // Configura a ação do botão "apagar" para excluir um registro no banco de
        // dados
        // apagar.addActionListener(e -> {
        // operacoes.apagar( clienteCPFField.getText());
        // // Limpa os campos de entrada após a operação de exclusão
        // clienteNomeField.setText("");
        // clienteIdadeField.setText("");
        // clienteCPFField.setText("");
        // });

    }

    // Métodos (Atualizar tabela)
    // Método para atualizar a tabela de exibição com dados do banco de dados
    // private void atualizarTabela() {
    //     tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
    //     clientes = new ClientesDAO().listarTodos();
    //     // Obtém os clientes atualizados do banco de dados
    //     for (Clientes cliente : clientes) {
    //         // Adiciona os dados de cada cliente como uma nova linha na tabela Swing
    //         tableModel.addRow(new Object[] { cliente.getNome(), cliente.getIdade(),

    //                 cliente.getCpf() });
    //     }
    // }
}
