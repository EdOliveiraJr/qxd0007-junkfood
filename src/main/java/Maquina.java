import java.util.ArrayList;
import java.util.Vector;

import jdk.nashorn.internal.runtime.regexp.joni.ast.QuantifierNode;

public class Maquina {
    private int qtdEspirais;
    private int maximoProdutos;
    private double faturamento;
    private double saldo;
    
    ArrayList <Espiral> espirais;

    public Maquina(int qtdEspirais, int maximoProdutos){
        this.qtdEspirais = qtdEspirais;
        this.maximoProdutos = maximoProdutos;
        espirais = new ArrayList<>();
        
        for (int i = 0; i < qtdEspirais; i++) {
            espirais.add(new Espiral());
        }
    }

    public double getFaturamento() {
        return faturamento;
    }

    public int getMaximoProdutos() {
        return maximoProdutos;
    }

    public double getSaldoCliente() {
        return saldo;
    }

    public int getSizeEspirais(){
        return qtdEspirais;
    }

    public Espiral getEspiral(int indice){
        if(indice >= getSizeEspirais() || indice < 0){
            return null;
        }
        return espirais.get(indice);
    }

    public int getProdutosNasEspirais(){
        int total = 0;
        for (Espiral espiral : espirais) {
            total += espiral.getQuantidade();
        }
        return total;
    }

    public boolean inserirDinheiro(double value){
        if(value <= 0){
            return false;
        }
        this.saldo += value;
        return true;
    }

    public double receberTroco(){
        double troco = saldo;
        saldo = 0.0;
        return troco;
    }

    public boolean alterarEspiral(int indice, String nome, int quantidade, double preco){
        if(indice >= getSizeEspirais() || indice < 0){
            return false;
        }
        if(maximoProdutos >= getProdutosNasEspirais() + quantidade){
            Espiral nova = new Espiral();
            nova.setNomeDoProduto(nome);
            nova.setQuantidade(quantidade);
            nova.setPreco(preco);
            espirais.set(indice, nova);
            return true;
        }else{
            return false;
        }
        
    }

    public boolean limparEspiral(int indice){
        
        if(indice >= getSizeEspirais() || indice < 0){
            return false;
        }

        espirais.set(indice, new Espiral());
        return true;
    }

    public boolean vender(int indice){
        if(indice < 0 || indice >= getSizeEspirais()){
            return false;
        }
        if(saldo < getEspiral(indice).getPreco()){
            return false;
        }
        saldo -= espirais.get(indice).getPreco();
        getEspiral(indice).darSaida();       
        return true;
        
    }
}