import java.util.LinkedList;
import java.util.Queue;

// ============================================================
// TASK 5 – Account Opening Queue (Admin Simulation)
// Users submit account requests > Admin processes them
// ============================================================
public class AccountRequestQueue {

    // Pending account requests
    private Queue<BankAccount> accountRequests = new LinkedList<>();
    private int nextAccountNumber = 100; // auto-assign account numbers

    // -- TASK 5 -- User submits an account opening request
    public void submitRequest(String username, double initialBalance) {
        BankAccount newRequest = new BankAccount(nextAccountNumber++, username, initialBalance);
        accountRequests.add(newRequest);
        System.out.println("Request submitted for: " + username);
    }

    // -- TASK 5 -- Admin processes next request (moves to main LinkedList)
    public BankAccount processNextRequest() {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending account requests.");
            return null;
        }
        BankAccount approved = accountRequests.poll();
        System.out.println("Admin approved account for: " + approved.username
                + " (Account #" + approved.accountNumber + ")");
        return approved; // caller adds this to BankLinkedList
    }

    // -- TASK 5 -- Display all pending requests
    public void displayPending() {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }
        System.out.println("Pending Account Requests:");
        int i = 1;
        for (BankAccount req : accountRequests) {
            System.out.println(i++ + ". " + req.username
                    + " | Initial Balance: " + req.balance);
        }
    }
}