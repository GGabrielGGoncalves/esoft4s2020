package atividade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Pattern;

public class PessoaFisica {

    public PessoaFisica(String cpf, String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        setCpf(cpf);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;
    private String telefone;
    private char sexo;
    private List<Venda> vendas;

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!cpfEstaValido(cpf)) {
            throw new RuntimeException("Cpf inválido.");
        }

        this.cpf = cpf;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        if (!Pattern.matches("[A-Za-z]", sobrenome)) {
            throw new RuntimeException("O sobrenome de possuir somente letras.");
        }

        this.sobrenome = sobrenome;
    }

    public void setNome(String nome) {
        if (!Pattern.matches("[A-Za-z]", nome)) {
            throw new RuntimeException("O nome de possuir somente letras.");
        }

        this.nome = nome;
    }

    public void adicionarVenda(Venda venda) {
        if (this.vendas == null || this.vendas.size() <= 0) {
            this.vendas = new ArrayList<>(Arrays.asList(venda));
        }
        else{
            this.vendas.add(venda);
        }
    }

    public void removerVenda (short codigoVenda) {
        if (!possuiVenda(codigoVenda)) {
            throw new RuntimeException("Venda não encontrada.");
        }
        
        this.vendas.removeIf(d -> d.getCodigo() == codigoVenda);
    }

    public boolean possuiVenda(int codigoVenda) {
        if (this.vendas == null || this.vendas.isEmpty()) {
            return false;
        }

        for (Venda venda : this.vendas) {
            if (codigoVenda ==  venda.getCodigo()) {
                return true;
            }
        }

        return false;
    }

    public static boolean cpfEstaValido(String CPF) {
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
                || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
                || CPF.equals("99999999999") || (CPF.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return (true);
            else
                return (false);

        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    @Override
    public  String toString() {       
        return "Pessoa Física [nome=" + this.nome + ","
            + "sobrenome=" + this.sobrenome + "," 
            + "rg=" + this.rg + "," 
            + "cpf=" + this.cpf + "," 
            + "sexo=" + this.sexo + "," 
            + "]";
    }
}
