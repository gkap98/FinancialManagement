public class StockPurchase {

    private String stockName;
    private String ticker;
    private Double numberOfSharesInPurchase;
    private Double stockPurchasePrice;

    public StockPurchase(String name, String tick, Double numOfShares, Double purchasePrice) {
        stockName = name;
        ticker = tick;
        numberOfSharesInPurchase = numOfShares;
        stockPurchasePrice = purchasePrice;
    }

    public String getStockName() {
        return stockName;
    }
    public String getTickerName() {
        return ticker;
    }
    public Double getNumberOfSharesInPurchase() {
        return numberOfSharesInPurchase;
    }
    public Double getPurchasePrice() {
        return stockPurchasePrice;
    }
}