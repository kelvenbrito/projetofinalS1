package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {
    // criação do tabbedPane para incluir as tabs
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        // tab1 carros
        CadastroProdutosPainel tab1 = new CadastroProdutosPainel();
        jTPane.add("Cadastro de produtos", tab1);
        VendasPainel tab2 = new VendasPainel();
        jTPane.add("Vendas", tab2);
     
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
