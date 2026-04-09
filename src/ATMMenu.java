import java.util.Scanner;

// ============================================================
// PART 3 – ATM Menu
// User can: balance enquiry, withdraw
// ============================================================
public class ATMMenu {

    public static void run(BankLinkedList bankList,
                           TransactionStack history,
                           Scanner scanner) {

        boolean inATM = true;

        while (inATM) {
            System.out.println("\n====== ATM MENU ======");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw");
            System.out.println("0 - Back");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: // Balance enquiry
                    System.out.print("Enter username: ");
                    String uname = scanner.nextLine();
                    BankAccount acc = bankList.searchByUsername(uname);
                    if (acc != null) {
                        System.out.println("Balance for " + acc.username
                                + ": " + acc.balance);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 2: // Withdraw (Task 2)
                    System.out.print("Enter username: ");
                    String witUser = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double witAmt = scanner.nextDouble();
                    scanner.nextLine();
                    bankList.withdraw(witUser, witAmt, history);
                    break;

                case 0:
                    inATM = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}