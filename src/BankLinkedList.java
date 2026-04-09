// ============================================================
// TASK 1 – Custom LinkedList to store BankAccount objects
// TASK 2 – Deposit and Withdraw methods added here
// ============================================================
public class BankLinkedList {

    // Inner Node class for the linked list
    private static class Node {
        BankAccount account;
        Node next;

        Node(BankAccount account) {
            this.account = account;
            this.next = null;
        }
    }

    private Node head;   // First node
    private int size;    // Track number of accounts

    // ── TASK 1 ── Add a new account to the end of the list
    public void addAccount(BankAccount account) {
        Node newNode = new Node(account);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Account added successfully");
    }

    // -- TASK 1 -- Display all accounts
    public void displayAll() {
        if (head == null) {
            System.out.println("No accounts found.");
            return;
        }
        System.out.println("Accounts List:");
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.account);
            current = current.next;
            index++;
        }
    }

    // -- TASK 1 -- Search account by username (returns account or null)
    public BankAccount searchByUsername(String username) {
        Node current = head;
        while (current != null) {
            if (current.account.username.equalsIgnoreCase(username)) {
                return current.account;
            }
            current = current.next;
        }
        return null;
    }

    // ── TASK 2 ── Deposit money into account
    public void deposit(String username, double amount, TransactionStack history) {
        BankAccount acc = searchByUsername(username);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        acc.balance += amount;
        System.out.println("Deposit: " + amount);
        System.out.println("New balance: " + acc.balance);

        // -- TASK 3 -- Push transaction to stack
        history.push("Deposit " + amount + " to " + username);
    }

    // -- TASK 2 -- Withdraw money from account
    public void withdraw(String username, double amount, TransactionStack history) {
        BankAccount acc = searchByUsername(username);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        if (acc.balance < amount) {
            System.out.println("Insufficient balance.");
            return;
        }
        acc.balance -= amount;
        System.out.println("Withdraw: " + amount);
        System.out.println("New balance: " + acc.balance);

        // -- TASK 3 -- Push transaction to stack
        history.push("Withdraw " + amount + " from " + username);
    }
}