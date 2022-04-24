package com.collections.SetsAndHashSets.stockChallenge;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
    }
    public int addStock(StockItem item){
        if(item != null){
            StockItem inStock = list.getOrDefault(item.getName(),item);
            if(inStock != item){
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(),item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item,null);
        if((inStock!=null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return this.list.get(key);
    }

    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);// so that user does not modify anything it isn't supposed to, just a view to the under
        //lying collection
    }

    @Override
    public String toString() {
        String s = "\n Stock List\n";
        double totalCost = 0.0;
        for( Map.Entry<String,StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s+ stockItem+".There are "+stockItem.quantityInStock()+" in stock. value is "+stockItem.getPrice();
            s= s+ ": "+String.format("%.2f",itemValue)+"\n";
            totalCost+= itemValue;
        }
        return s+ "Total stock value "+totalCost;
    }
}
