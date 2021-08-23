public class Espiral{
    private String nomeProduto = " - ";
    private int qtdProduto;
    private double preco;

    public Espiral(){
    }

    public String getNomeDoProduto(){
        return nomeProduto;
    }

    public int getQuantidade() {
        return qtdProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setNomeDoProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setQuantidade(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void darSaida(){
        qtdProduto--;
    }
}