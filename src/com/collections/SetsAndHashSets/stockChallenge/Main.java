package com.collections.SetsAndHashSets.stockChallenge;

public class Main {
    private static StockList stockList= new StockList();
    public static void main(String[] args) {
        StockItem stockItem= new StockItem("bread",0.86,100);
        stockList.addStock(stockItem);
        stockItem= new StockItem("cake",1.10,7);
        stockList.addStock(stockItem);
        stockItem= new StockItem("car",13.10,7);
        stockList.addStock(stockItem);
        stockItem= new StockItem("oven",13.10,7);
        stockList.addStock(stockItem);
        stockItem= new StockItem("oven",10.10,7);
        stockList.addStock(stockItem);
        System.out.println(stockList);
        for(String s: stockList.Items().keySet()){
            System.out.println(s);
        }
        Basket basket = new Basket("AVI");
        sellItem(basket,"car",2);
        System.out.println(basket);
        sellItem(basket,"car",5);
        System.out.println(basket);
        sellItem(basket,"rat",2);
        sellItem(basket,"oven",2);
        sellItem(basket,"cake",2);
        System.out.println(basket);
        System.out.println(stockList  );
    }

    public static int sellItem(Basket basket,String item,int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("we don't sell "+ item);
            return  0;
        }
        if(stockList.sellStock(item,quantity) != 0){
            basket.addToBasket(stockItem,quantity);
            return quantity;
        }
        return 0;
    }
}
