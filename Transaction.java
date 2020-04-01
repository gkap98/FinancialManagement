public class Transaction {

    private String transactionType;
    private Double transactionAmount;

    public Transaction(String transType, Double transAmmount) {
        transactionType = transType;
        transactionAmount = transAmmount;
    }

    public String getTranType() {
        return transactionType;
    }
    public Double getTranAmmount() {
        return transactionAmount;
    }
}