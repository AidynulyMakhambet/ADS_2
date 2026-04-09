import java.util.Scanner;

// ============================================================
// PART 3 – Bank Menu
// User can: submit account request, deposit, withdraw
// Uses: LinkedList accounts + Stack history
// ============================================================
public class BankMenu {

    public static void run(BankLinkedList bankList,
                           TransactionStack history,
                           AccountRequestQueue requestQueue,
                           Scanner scanner) {

        boolean inBank = true;

        while (inBank) {
            System.out.println("\n====== BANK MENU ======");
            System.out.println("1 - Submit account opening request");
            System.out.println("2 - Deposit money");
            System.out.println("3 - Withdraw money");
            System.out.println("0 - Back");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: // Submit account request → goes to queue (Task 5)
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double initBal = scanner.nextDouble();
                    scanner.nextLine();
                    requestQueue.submitRequest(name, initBal);
                    break;

                case 2: // Deposit (Task 2)
                    System.out.print("Enter username: ");
                    String depUser = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double depAmt = scanner.nextDouble();
                    scanner.nextLine();
                    bankList.deposit(depUser, depAmt, history);
                    break;

                case 3: // Withdraw (Task 2)
                    System.out.print("Enter username: ");
                    String witUser = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double witAmt = scanner.nextDouble();
                    scanner.nextLine();
                    bankList.withdraw(witUser, witAmt, history);
                    break;

                case 0:
                    inBank = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}