package AccountManagement;

public class Account {

    // Attributes
    private final String holderName;
    private final String accountNumber;
    private double balance;
    private final double withdrawLimit;
    private double currentWithdrawLimit;
    private double negativeLimit;

    // Constructor
    public Account(String holderName, String accountNumber, double balance, double withdrawLimit, double negativeLimit) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
        this.currentWithdrawLimit = withdrawLimit;
        this.negativeLimit = negativeLimit;
    }

    // Methods
    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > this.currentWithdrawLimit) {
            System.out.println("Withdraw error: The amount exceeds withdraw limit");
        } else if (amount > this.balance) {
            System.out.println("Withdraw error: Not enough balance");
        } else {
            this.balance -= amount;
            this.currentWithdrawLimit -= amount;
        }
    }

    public void resetWithdrawLimit() {
        this.currentWithdrawLimit = this.withdrawLimit;
    }

    public void setNegativeLimit(double negativeLimit) {
        this.negativeLimit = negativeLimit;
    }

    public double getNegativeLimit() {
        return this.negativeLimit;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getHolderName() {
        return this.holderName;
    }

    public double getWithdrawLimit() {
        return this.withdrawLimit;
    }

    public double getCurrentWithdrawLimit() {
        return this.currentWithdrawLimit;
    }

}
