# Object Oriented Programming program for a financial management team.
  - Our financial management client needs some software to keep track of different types of accounts. Checking accounts have an account number, a first and last name for the account holder, a primary mailing address of the account holder, and a balance. One can make deposits and withdrawals from a checking account. Our client needs to generate reports that include the account number, the name and primary address of the account holder, the current balance, and information about all the transactions.

  - In addition to checking accounts our client manages equity accounts. Equity accounts have an account number, a first and last name for the account holder, a primary mailing address of the account holder, and a list of stock purchases. Each stock purchase has a stock name, ticker symbol, purchase price per share, and number of shares at the purchase price. Our client needs to generate reports that include the account number, the name and primary address of the account holder, a list of all stock information, and a total value for the equities in the account. (You will create a class that you can query for current stock prices. Store the ticker symbols and 'fake' current values for stocks in a file and have the class read it.)

## Inheritance and Polymorphism
  - use a hierarchy for accounts
  - create abstract class(es)

## Checking
  - can record all deposits and withdraws

## Equity
  - can record stock purchases
  - has a class to retrieve 'fake' current values from a file

## Report
  - shows all transactions
  - generate html file

## Driver
  - method that takes a list of accounts and sorts them by value
