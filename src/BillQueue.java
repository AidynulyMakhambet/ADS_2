import java.util.LinkedList;
import java.util.Queue;

// ============================================================
// TASK 4 – Bill Payment Queue (FIFO) using LinkedList as Queue
// ============================================================
public class BillQueue {

    // Queue backed by LinkedList (FIFO behavior)
    private Queue<String> billQueue = new LinkedList<>();

    // ── TASK 4 ── Add a bill payment request to the queue
    public void addBill(String billName) {
        billQueue.add(billName);
        System.out.println("Added: " + billName);
    }

    // -- TASK 4 -- Process (remove) the next bill from the front
    public void processNext() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills to process.");
            return;
        }
        String processed = billQueue.poll(); // removes front element
        System.out.println("Processing: " + processed);
    }

    // -- TASK 4 -- Display all pending bills in the queue
    public void displayQueue() {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
            return;
        }
        System.out.println("Pending Bills:");
        for (String bill : billQueue) {
            System.out.println("  - " + bill);
        }
    }
}