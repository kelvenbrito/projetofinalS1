package Model;

public class Produtos {
    //=============Atributos=============
    private String nome;
    private String codigoBarra;
    private String preco;
     private String quantidade;

    //=============Construtor=============
      public Produtos(String nome, String codigoBarra, String preco, String quantidade) {
        this.nome = nome;
        this.codigoBarra = codigoBarra;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    //=============Get and Set=============
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigoBarra() {
        return codigoBarra;
    }
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }
    public String getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

}
