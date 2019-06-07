package dataobjects;

import java.util.Map;

public class TradesSmStock {

    private int price;
    private int quantity;
    private String buyOrSell;

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

    public static TradesSmStock createSmStockTrade(Map<String, String> entry) {
        TradesSmStock trade = new TradesSmStock();
        trade.setPrice(Integer.parseInt(entry.get("price")));
        trade.setQuantity(Integer.parseInt(entry.get("quantity")));
        trade.setBuyOrSell(entry.get("buyOrSell"));

        return trade;
    }
    @Override
    public String toString() {
        return "TradesDfStock [price=" + price + ", quantity=" + quantity + ", buyOrSell=" + buyOrSell + "]";
    }

}
