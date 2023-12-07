package Model;

public class Vendas {
    // =============Atributos=============
    private String cpf;
    private String totalCompra;
    private String dataHora;
    private String idSerial;

    // =============Construtor=============
    public Vendas(String cpf, String totalCompra, String dataHora, String idSerial) {
        this.cpf = cpf;
        this.totalCompra = totalCompra;
        this.dataHora = dataHora;
        this.idSerial = idSerial;
    }

    // =============Get and Set=============

    public String getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(String totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getIdSerial() {
        return idSerial;
    }

    public void setIdSerial(String idSerial) {
        this.idSerial = idSerial;
    }

}
