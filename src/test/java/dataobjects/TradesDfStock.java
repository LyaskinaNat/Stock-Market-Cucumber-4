package dataobjects;

import java.util.Map;

public class TradesDfStock {

    private String stock;
    private int price;
    private int quantity;
    private String buyOrSell;

    public String getStock() {
        return stock;
    }
    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String getBuyOrSell() {
        return buyOrSell;
    }
    public void setBuyOrSell(String buyOrSell) {
        this.buyOrSell = buyOrSell;
    }

    public static TradesDfStock createDfStockTrade(Map<String, String> entry) {
        TradesDfStock trade = new TradesDfStock();
        trade.setStock(entry.get("stock"));
        trade.setPrice(Integer.parseInt(entry.get("price")));
        trade.setQuantity(Integer.parseInt(entry.get("quantity")));
        trade.setBuyOrSell(entry.get("buyOrSell"));

        return trade;
    }
    @Override
    public String toString() {
        return "TradesDfStock [stock=" + stock + ", price=" + price + ", quantity=" + quantity + ", buyOrSell=" + buyOrSell + "]";
    }

}
