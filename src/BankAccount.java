// ============================================================
// TASK 1 – BankAccount class (data model)
// ============================================================
public class BankAccount {
    int accountNumber;
    String username;
    double balance;

    // Constructor
    public BankAccount(int accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return username + " - Balance: " + balance;
    }
}