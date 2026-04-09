import java.util.Stack;

// ============================================================
// TASK 3 – Transaction History using Stack (LIFO)
// ============================================================
public class TransactionStack {

    // Stack stores transaction strings
    private Stack<String> transactionHistory = new Stack<>();

    // -- TASK 3 -- Push a transaction onto the stack
    public void push(String transaction) {
        transactionHistory.push(transaction);
        System.out.println("Transaction recorded: " + transaction);
    }

    // -- TASK 3 -- Peek at the last transaction (without removing)
    public void peek() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("Last transaction: " + transactionHistory.peek());
    }

    // -- TASK 3 -- Undo (pop) the last transaction
    public void undo() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions to undo.");
            return;
        }
        String removed = transactionHistory.pop();
        System.out.println("Undo → " + removed + " removed");
    }

    // -- TASK 3 -- Display all transaction history
    public void displayAll() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transaction history.");
            return;
        }
        System.out.println("Transaction History (latest first):");
        // Print in reverse (LIFO order)
        Stack<String> temp = new Stack<>();
        temp.addAll(transactionHistory);
        int i = temp.size();
        while (!temp.isEmpty()) {
            System.out.println(i + ". " + temp.pop());
            i--;
        }
    }
}