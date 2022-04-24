package com.collections.SetsAndHashSets.stockChallenge;

import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

public class Basket {

    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if(item != null &&(quantity>0)){
            int inBasket = list.getOrDefault(item,0);
            list.put(item,inBasket+quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> items(){
        return  Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        double totalCost = 0.0;
        String s= "Shopping Basket{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
        for(Map.Entry<StockItem,Integer> item:list.entrySet()){
            s+=item.getKey()+".\n "+item.getValue()+" purchased\n";
            totalCost+=item.getKey().getPrice()*item.getValue();
        }
        return s+" Total cost "+totalCost;
    }
}
