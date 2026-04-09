import java.util.Scanner;

// ============================================================
// MAIN – Simple entry point. Creates shared objects, runs menu.
// ============================================================
public class Main {

    public static void main(String[] args) {

        // ── Shared objects (used across all menus) ──
        BankLinkedList bankList = new BankLinkedList();
        TransactionStack history = new TransactionStack();
        BillQueue billQueue = new BillQueue();
        AccountRequestQueue requestQueue = new AccountRequestQueue();
        Scanner scanner = new Scanner(System.in);

        // Pre-load sample accounts
        bankList.addAccount(new BankAccount(1, "Ali",  150000));
        bankList.addAccount(new BankAccount(2, "Sara", 220000));

        // Run Task 6 demo once on startup
        Task6ArrayDemo.run();

        // -- Main Menu (Part 3) --
        boolean running = true;
        while (running) {
            System.out.println("\n========= MAIN MENU =========");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> BankMenu.run(bankList, history, requestQueue, scanner);
                case 2 -> ATMMenu.run(bankList, history, scanner);
                case 3 -> AdminMenu.run(bankList, requestQueue, billQueue, scanner);
                case 4 -> { System.out.println("Goodbye!"); running = false; }
                default -> System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}