package Model;

public class Compras {
    // =============Atributos=============
    private String quantidade;
    private String totalCompra;
    private String formaPagamento;

    // =============Construtor=============
    public Compras(String quantidade, String totalCompra, String formaPagamento) {
        this.quantidade = quantidade;
        this.totalCompra = totalCompra;
        this.formaPagamento = formaPagamento;
    }

    // =============Get and Set=============
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(String totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

}
