import java.util.ArrayList;

public class Equity extends Account {
    private Double equityBalance;
    private Double initialBalance;
    private ArrayList<StockPurchase> stockPurchaseHistory;

    public Equity(String fName, String lName, String mailingAddressString, Double bal) {
        super(fName, lName, mailingAddressString, bal);
        equityBalance = 0.0;
        initialBalance = bal;
        stockPurchaseHistory = new ArrayList<StockPurchase>();
    }
    @Override
    public Double getCurrentValue() {
        ReadTicker stockValues = new ReadTicker();
        Double portfolioValue = getInitialBalance();
        for (int i = 0; i < stockPurchaseHistory.size(); i++) {
            portfolioValue += stockPurchaseHistory.get(i).getNumberOfSharesInPurchase() * stockValues.getCurrentStockValue(stockPurchaseHistory.get(i).getTickerName());
        }
        return portfolioValue;
    }

    public Double getEquityBalance() {
        return equityBalance;
    }
    public Double getInitialBalance() {
        return initialBalance;
    }
    public ArrayList<StockPurchase> getStockPurchaseHistory() {
        return stockPurchaseHistory;
    }
    public void newStockPurchase(String name, String tick, Double numShares, Double purchasePrice) {
        StockPurchase stk = new StockPurchase(name, tick, numShares, purchasePrice);
        equityBalance += (numShares * purchasePrice);
        stockPurchaseHistory.add(stk);
    }
}