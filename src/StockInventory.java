import java.util.ArrayList;
import java.util.HashMap;

public class StockInventory {

    private HashMap<Produto,Integer> inventorio;
    private static StockInventory estruturaSingleton=null;

    private StockInventory(){
        this.inventorio=new HashMap<>();
    }
    public static StockInventory getInventorio(){
        if(estruturaSingleton==null){
            estruturaSingleton=new StockInventory();
        
        }
        return estruturaSingleton;
    }
    public void addProduto(Produto produto, int quantidade){
        if(this.inventorio.containsKey(produto)){
            quantidade=quantidade+inventorio.get(produto);
        }
        inventorio.put(produto, quantidade);
    }
    public double mediaValorProdutos(){
        double media = this.inventorio.keySet().stream().mapToDouble(Produto::getPrice).average().getAsDouble();
        return media;
    }
    public double quantidadeDeItems(){
        double total=0;
        return total=this.inventorio.values().stream().mapToDouble(d->d).sum();
    }
    public double valorTotalCatalogo(){
        double total=0;
        for(var entry:inventorio.entrySet()){
            total+=entry.getValue()*entry.getKey().getPrice();
        }
        return total;
    }
    public void printerToConsole(boolean printeMode){
        for(var entry:inventorio.entrySet()){
            if(entry.getValue()<=0&&printeMode){
                continue;
                }
            else{
                System.out.println(" Produto: "+entry.getKey().getName()+" Preço:"+entry.getKey().getPrice()+" Unidades em Stock: "+entry.getValue());
                }
            }    
    }
    public void listaPorMenorProduto(){
        HashMap<Produto,Integer> inventorioTemporario=this.inventorio;
        HashMap<Produto,Integer> inventorioOrdenado=new HashMap<>();
        ArrayList<Produto> ArraylistOrdenada= new ArrayList<>();
        int numeroItems=inventorioTemporario.size();
        Produto prodTemporario=null;
        double valorMinimo=2000;
        while(numeroItems>0){            
            for(var entry:inventorioTemporario.entrySet()){
                if(entry.getValue()<valorMinimo){
                    valorMinimo=entry.getValue();
                    prodTemporario=entry.getKey();
                }
            }
            inventorioOrdenado.put(prodTemporario,(int)valorMinimo);
            ArraylistOrdenada.add(prodTemporario);
    
            inventorioTemporario.remove(prodTemporario);
            valorMinimo=2000;
            prodTemporario=null;
            numeroItems--;
            
        }
        for(Produto prod:ArraylistOrdenada){
            System.out.println("Produto: "+prod.getName()+" Preço: "+prod.getPrice()+" Quantidade "+inventorioOrdenado.get(prod));
        }
    }

}
