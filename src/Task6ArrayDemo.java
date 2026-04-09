// ============================================================
// TASK 6 – Physical Data Structure: Array of BankAccounts
// Creates BankAccount[3], stores 3 predefined accounts, prints
// ============================================================
public class Task6ArrayDemo {

    public static void run() {
        // Create fixed-size array of 3 BankAccount objects
        BankAccount[] accounts = new BankAccount[3];

        // Store 3 predefined accounts
        accounts[0] = new BankAccount(101, "Ali",   150000);
        accounts[1] = new BankAccount(102, "Sara",  220000);
        accounts[2] = new BankAccount(103, "Amir",  95000);

        // Print all accounts
        System.out.println("\n--- Task 6: BankAccount Array ---");
        for (int i = 0; i < accounts.length; i++) {
            System.out.println((i + 1) + ". " + accounts[i]);
        }
    }
}