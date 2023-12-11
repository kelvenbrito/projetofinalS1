package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesDAO;
import Connection.ProdutosDAO;
import Connection.VendasDAO;
import Controller.ProdutosControl;
import Controller.VendasControl;
import Model.Produtos;
import Model.Vendas;
import Model.Clientes;

public class VendasPainel extends JPanel {
    // Atributos(componentes)
    private JButton inserirProduto, apagarProduto, editarProduto, finalizarVenda, cadastrar;
    private JTextField clienteCpfField, codigoProdutoField, quantidadeProdutoField;
    private JLabel valorFinal, status;
    private JComboBox formaPagamento;

    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    private List<Vendas> vendas;
    private List<Clientes> clientes;
    private List<Produtos> produtos;

    //
    // Construtor(GUI-JPanel)
    public VendasPainel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Caixa de Vendas"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("CPF"));
        clienteCpfField = new JTextField(20);
        inputPanel.add(clienteCpfField);
        // Status Cliente
        inputPanel.add(status = new JLabel("Não Cadastrado"));
        inputPanel.add(cadastrar = new JButton("Cadastrar"));
        // Forma de pagamento
        inputPanel.add(new JLabel("Forma de Pagamento"));
        String[] formasPagamento = { "Dinheiro", "Cartão de Crédito", "Pix", "Vale Alimentação" };
        JComboBox<String> formaPagamento = new JComboBox<>(formasPagamento);
        inputPanel.add(formaPagamento);
        inputPanel.add(new JLabel("Código do Produto"));
        codigoProdutoField = new JTextField(3);
        inputPanel.add(codigoProdutoField);
        inputPanel.add(new JLabel("Quantidade"));
        quantidadeProdutoField = new JTextField(3);
        quantidadeProdutoField.setText("1");
        inputPanel.add(quantidadeProdutoField);
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(inserirProduto = new JButton("Inserir"));
        botoes.add(apagarProduto = new JButton("Editar"));
        botoes.add(finalizarVenda = new JButton("Apagar"));
        add(botoes);
        // Total da compra
        JPanel precoTotal = new JPanel();
        precoTotal.setLayout(new BorderLayout());
        precoTotal.add(new JLabel("Valor Final da Compra: "), BorderLayout.WEST);
        precoTotal.add(valorFinal = new JLabel("12545"), BorderLayout.CENTER);
        add(precoTotal);
        // tabela de clientes
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);

        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Código", "Nome", "Quantidade", "Preço", "Desconto VIP" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        JPanel teste = new JPanel();
        teste.add(finalizarVenda = new JButton("Finalizar"));
        add(teste);

        // Cria o banco de dados caso não tenha sido criado
        new VendasDAO().criaTabela();
       

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

        clienteCpfField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    clientes = new ClientesDAO().listarTodos();
                    for (Clientes cliente : clientes) {
                        if (clienteCpfField.getText().equals(cliente.getCpf())) {
                            status.setText("Cliente cadastrado!");
                            break;
                        } else {
                            status.setText("Cliente não cadastrado!");
                        }
                    }

                }
            }
        });

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // Formato personalizado
        String dataHora = dateTime.format(formatter); // Obtém data e hora formatadas

        VendasControl operacoes = new VendasControl(vendas, tableModel, table);
        // tratamento para botão cadastrar
        finalizarVenda.addActionListener(e -> {
            operacoes.cadastrar(clienteCpfField.getText(), valorFinal.getText(), dataHora);

        });

        inserirProduto.addActionListener(e -> {
            produtos = new ProdutosDAO().listarTodos();
            boolean verificPoduto = false;
              double vf = 0;
            for (Produtos produto : produtos) {
                if (codigoProdutoField.getText().equals(produto.getCodigoBarra())) {
                    tableModel.addRow(new Object[] {  produto.getCodigoBarra(), produto.getNome(),quantidadeProdutoField.getText(), produto.getPreco(),25  });
                  vf += produto.getPreco() *  Double.parseDouble(quantidadeProdutoField.getText());
                    valorFinal.setText(  vf + "");
                   
                    verificPoduto = true;
                  
                } 
            }
            if (!verificPoduto) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            }
        });

       cadastrar.addActionListener(e -> {
        // Exibe o painel com a tabela de histórico de vendas
            JFrame cadFrame = new JFrame("Cadastro de cliente");
            cadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cadastroCliente tab3 = new cadastroCliente();
             cadFrame.add(tab3);
            cadFrame.pack();
            cadFrame.setVisible(true);
        });

    }


}
