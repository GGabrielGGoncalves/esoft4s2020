package atividade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class AtividadeMain {
    public static void main(String[] args) {
        PessoaFisica vendedor = new PessoaFisica("60968166300", "Sophia", "Mariana Vera da Cunha");
        Venda venda = new Venda();
        Produto produto = new Produto();

        produto.setCodigo(2131);
        produto.setNome("Fralda Pampers M");
        produto.setQuantidade(5);
        produto.setValor((float)24.99);

        venda.setCodigo(1234);
        venda.setData(new Date(2020, 9, 20));
        venda.setFormaPagamento(new FormaPagamento("Cartão de Crédito", 6));
        venda.setProdutos(new ArrayList<>(Arrays.asList(produto)));
        venda.setValor((float)24.99);

        vendedor.adicionarVenda(venda);
    }
}
