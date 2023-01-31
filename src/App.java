public class App {
    public static void main(String[] args) throws Exception {
        StockInventory stock = StockInventory.getInventorio();

        stock.addProduto(new Produto(5, "Banana", "1"), 10);
        stock.addProduto(new Produto(5, "Maça", "2"), 15);
        stock.addProduto(new Produto(5, "Manga", "3"), 20);
        stock.addProduto(new Produto(5, "Morango", "4"), 8);
        stock.addProduto(new Produto(5, "Ananas", "5"), 30);
        
        System.out.println("o Preço Medio dos Artigos no nosso stock é: "+stock.mediaValorProdutos());
        System.out.println("o Numero Total de Unidades em stock é : "+stock.quantidadeDeItems());
        System.out.println("O Valor total do stock é "+stock.valorTotalCatalogo());
        boolean printerMode=true;
        stock.printerToConsole(printerMode);
        stock.listaPorMenorProduto();
    }
}
