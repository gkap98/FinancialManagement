import java.util.Comparator;
public abstract class Account {
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String mailingAddress;  // Street, City State, Zip
    private Double initialBalance;

// *****************
//   Constructors
// *****************
    public Account(String fName, String lName, String mailingAddressString, Double initBal) {
        firstName = fName;
        lastName = lName;
        mailingAddress = mailingAddressString;
        initialBalance = initBal;
    }
// *****************
//     Getters
// *****************
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return mailingAddress;
    }
    public Double getInitialBalance() {
        return initialBalance;
    }
// *****************
//     Setters
// *****************
    public void setFirstName(String name) {
        firstName = name;
    }
    public void setLastName(String name) {
        lastName = name;
    }
    public void setAddress(String addrs) {
        mailingAddress = addrs;
    }
    public void setAccountNumber(String num) {
        accountNumber = num;
    }

// *****************
//    Functions
// *****************
    public abstract Double getCurrentValue();

    public static Comparator <Account> ValueComparator = new Comparator<Account>() {
        @Override
        public int compare(Account a1, Account a2) {
            int returnValue;
            if (a1.getCurrentValue() < a2.getCurrentValue()) {
                returnValue = 1;
            } else if (a1.getCurrentValue() == a2.getCurrentValue()) {
                returnValue = 0;
            } else {
                returnValue = -1;
            }
            return returnValue;
        }
    };
}