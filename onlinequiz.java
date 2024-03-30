import java.util.Scanner;

public class onlinequiz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int accBal = 0; // Initialize account balance
        int choice;

        System.out.print("Enter account holder's name: ");
        String accHolder = sc.next();

        while (true) {
            // Display menu
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int deposit = sc.nextInt();
                    accBal += deposit; // Add deposit amount to account balance
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdraw = sc.nextInt();
                    if (withdraw <= accBal) {
                        accBal -= withdraw; // Deduct withdrawal amount from account balance
                    } else {
                        System.out.println("Insufficient balance");
                    }
                    break;

                case 3:
                    System.out.println("Current balance: " + accBal);
                    break;

                case 4:
                    System.out.println("Exiting program");
                    System.exit(0); // Exit the program
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}