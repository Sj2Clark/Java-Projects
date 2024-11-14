package banking_application;

// Declare Account class
public class Account {

    // Private field to store account number
    private int accountNumber;

    // Private field to store account type
    private String accountType;

    // Private field to store account name
    private String name;

    // Private field to store account balance
    private double balance;

    // Getter method for account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Setter method for account number
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter method for account type
    public String getAccountType() {
        return accountType;
    }

    // Setter method for account type
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // Getter method for account name
    public String getName() {
        return name;
    }

    // Setter method for account name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for account balance
    public double getBalance() {
        return balance;
    }

    // Setter method for account balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // toString method to return bank account details in string format
    @Override
    public String toString() {
        return "\nAccount #: " + getAccountNumber() + "\nAccount Type: " + getAccountType() + "\nName: " + getName() + "\nBalance: $" + getBalance();
    }
}
