package atividade;

import java.sql.Date;
import java.util.List;

public class Venda {

    public Venda() {

    }

    public Venda(Date data, float valor, int codigo, FormaPagamento formaPagamento) {
        this(data, valor, codigo);
        this.formaPagamento = formaPagamento;
    }

    public Venda(Date data, float valor, int codigo) {
        this();
        this.data = data;
        this.valor = valor;
        this.codigo = codigo;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Venda(Date data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    public Venda(Date data, float valor, List<Produto> produtos) {
        this(data, valor);
        this.produtos = produtos;
    }

    private List<Produto> produtos;
    private Date data;
    private float valor;
    private int codigo;
    private FormaPagamento formaPagamento;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
