import java.util.Scanner;

// ============================================================
// PART 3 – Admin Menu
// Admin can: view/process account queue, view bill queue
// ============================================================
public class AdminMenu {

    public static void run(BankLinkedList bankList,
                           AccountRequestQueue requestQueue,
                           BillQueue billQueue,
                           Scanner scanner) {

        boolean inAdmin = true;

        while (inAdmin) {
            System.out.println("\n====== ADMIN MENU ======");
            System.out.println("1 - View pending account requests");
            System.out.println("2 - Process next account request");
            System.out.println("3 - View bill payment queue");
            System.out.println("4 - Process next bill payment");
            System.out.println("5 - Add bill to queue");
            System.out.println("6 - View all accounts");
            System.out.println("0 - Back");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: // Display pending requests (Task 5)
                    requestQueue.displayPending();
                    break;

                case 2: // Process request → moves to LinkedList (Task 5)
                    BankAccount approved = requestQueue.processNextRequest();
                    if (approved != null) {
                        bankList.addAccount(approved);
                    }
                    break;

                case 3: // View bill queue (Task 4)
                    billQueue.displayQueue();
                    break;

                case 4: // Process next bill (Task 4)
                    billQueue.processNext();
                    break;

                case 5: // Add bill (Task 4)
                    System.out.print("Enter bill name: ");
                    String bill = scanner.nextLine();
                    billQueue.addBill(bill);
                    break;

                case 6: // View all accounts (Task 1)
                    bankList.displayAll();
                    break;

                case 0:
                    inAdmin = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}