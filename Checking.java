import java.util.ArrayList;

public class Checking extends Account {
    private ArrayList<Transaction> transactionHistory;
    private Double balance;
    private Double initialBalance;

    public Checking(String fName, String lName, String mailingAddressString, Double balance) {
        super(fName, lName, mailingAddressString, balance);
        transactionHistory = new ArrayList<Transaction>();
        setInitialBalance(balance);
        setBalance(balance);
    }
// GETTERS
    @Override
    public Double getCurrentValue() {
        return getBalance();
    }
    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
    public Double getBalance() {
        return balance;
    }
    public Double getInitialBalance() {
        return initialBalance;
    }
// SETTERS
    public void setBalance(Double bal) {
        balance = bal;
    }
    public void setInitialBalance(Double bal) {
        initialBalance = bal;
    }
// FUNCTIONS
    public void newTransaction(String transType, Double transAmmount) {
        Transaction tran = new Transaction(transType, transAmmount);
        if (transType == "Withdrawl") {
            balance = getBalance() - transAmmount;
        } else if (transType == "Deposit") {
            balance = getBalance() + transAmmount;
        } else {
            System.out.println();
            System.out.println("Transaction was voided due to unrecognized Transaction Type");
            System.out.println("Please indicate if the transaction is a 'Withdrawl' or a 'Deposite'");
        }
        transactionHistory.add(tran);
    }
}