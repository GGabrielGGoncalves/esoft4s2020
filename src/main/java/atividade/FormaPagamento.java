package atividade;

public class FormaPagamento {

    public FormaPagamento() {

    }

    public FormaPagamento(String descricao, int quantParcelas) {
        this.descricao = descricao;
        this.quantParcelas = quantParcelas;
    }

    private String descricao;
    private int quantParcelas = 1;

    public String getDescricao() {
        return descricao;
    }

    public int getQuantParcelas() {
        return quantParcelas;
    }

    public void setQuantParcelas(int quantParcelas) {
        this.quantParcelas = quantParcelas;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
