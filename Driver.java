import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Driver {
	public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        Account equity1 = new Equity("Gavin", "Kaepernick", "715 Highland dr, Bellingham WA, 98225", 500.00);
    // Setting account number for each account. Said we didn't need to automate.
        equity1.setAccountNumber("1");
    // Had to cast because accounts and equity's are of different type
        Equity equity = (Equity) equity1;
        equity.newStockPurchase("Microsoft", "MSFT", 10.00, 10.00);
        equity1 = equity;
        accounts.add(equity1);

        Account checking1 = new Checking("Will", "Gast", "4609 17th Ave, Kenosha WI, 53140", 100.00);
        checking1.setAccountNumber("2");
    // Same Casting thing here
        Checking checking = (Checking) checking1;
        checking.newTransaction("Deposit", 200.00);
        checking.newTransaction("Withdrawl", 50.00);
        checking1 = checking;
        accounts.add(checking1);

        Account checking2 = new Checking("Josh", "Hoffman", "1128 Highland Farms Dr, Wentzville MO, 63385", 150.00);
        checking2.setAccountNumber("3");
    // Same Casting thing here
        Checking checkingCast = (Checking) checking2;
        checkingCast.newTransaction("Deposit", 200.00);
        checkingCast.newTransaction("Deposit", 50.00);
        checking2 = checkingCast;
        accounts.add(checking2);

        Collections.sort(accounts, Account.ValueComparator);
        generateReport(accounts);
    }



    public static void generateReport(ArrayList<Account> accounts) {
        try {
            // Writing to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter("report.html", true));
            writer.append("<html>");
            writer.append("<body>");

            for (int i = 0; i < accounts.size(); i++) {
                writer.append("<h2> Account Number: </h2>");
                String st = accounts.get(i).getAccountNumber();
                writer.append(st);
                writer.append("<h2> Account Member Name: </h2>");
                st = accounts.get(i).getFirstName() + " " + accounts.get(i).getLastName();
                writer.append(st);
                writer.append("<h2> Account Holders Mailing Address: </h2>");
                st = accounts.get(i).getAddress();
                writer.append(st);
                writer.append("<h2> Initial Account Value: </h2>");
                st = accounts.get(i).getInitialBalance().toString();
                writer.append(st);
                writer.append("<h2> Current Account Value: </h2>");
                st = accounts.get(i).getCurrentValue().toString();
                writer.append(st);

                if (accounts.get(i) instanceof Checking) {
                // Casting thing here again
                    Checking checkingAcct = (Checking) accounts.get(i);
                    writer.append("<h2> Transaction History: </h2>");
                    for (int j = 0; j < checkingAcct.getTransactionHistory().size(); j++) {
                        st = checkingAcct.getTransactionHistory().get(j).getTranType();
                        writer.append(st);
                        writer.append(" --- ");
                        st = checkingAcct.getTransactionHistory().get(j).getTranAmmount().toString();
                        writer.append(st);
                        writer.append("<h2></h2>");
                    }
                } else if (accounts.get(i) instanceof Equity) {
                // Casting thing here
                    Equity equityAccount = (Equity) accounts.get(i);
                    writer.append("<h2> Stock Purchase History: </h2>");
                    for (int j = 0; j < equityAccount.getStockPurchaseHistory().size(); j++) {
                        st = equityAccount.getStockPurchaseHistory().get(j).getStockName();
                        writer.append(st);
                        writer.append(" --- ");
                        st = equityAccount.getStockPurchaseHistory().get(j).getTickerName();
                        writer.append(st);
                        writer.append(" --- ");
                        st = equityAccount.getStockPurchaseHistory().get(j).getNumberOfSharesInPurchase().toString();
                        writer.append(st + " Shares");
                        writer.append("<h2></h2>");
                    }
                }
                writer.append("<h2> ---------------------------------------------------------------------- </h2>");
            }

            writer.append("</body>");
            writer.append("</html>");
            writer.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Something went wrong here! File not found!");
        } catch(IOException exception) {
            System.out.println("Something whet wrong writing to file");;
        }
    }
}