/* Description: */
/* The following program prompts the user to open a bank account. The user enters their name, opts for either a
chequing or savings account, and enters a balance. The program displays a menu of options from which the user can choose
from, including checking their account balance and making a deposit or withdrawal. */

package banking_application;

// Import Java packages
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Declare Bank class
public class Bank {

    // Create static global double variable and assign it value of 0
    static double balance = 0;

    // Create main() method
    public static void main(String[] args) {

        // Create new integer and assign random number between 1000 and 9000 as the account number
        int accountNumber = new Random().nextInt(9000) + 1000;

        // Create new integer userInput and assign it value of 0
        int userInput = 0;

        // Create String accountType and assign it empty string
        String accountType = "";

        // Create String name
        String name;

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Enter first name
        System.out.println("Enter first name: ");
        name = scanner.nextLine();

        // Create Boolean object and assign it the isAlpha method
        boolean nameInput = isAlpha(name);

        // Loop while nameInput is false
        while (!nameInput) {

            // Prompt user to enter name again
            System.out.println("\nName can only contain letters");
            System.out.println("Enter first name: ");
            name = scanner.nextLine();
            nameInput = isAlpha(name);
        }

        // Create Boolean object and set it to false
        boolean validInput = false;

        // Loop while validInput is false
        while (!validInput) {

            // Loop while user input is not equal to 1 (chequing) or 2 (savings)
            while ((userInput != 1) && (userInput != 2)) {
                System.out.print("\nChoose account type:\n1. chequing\n2. savings\n");

                try { // Attempt to read user input

                    //Convert userInput into integer value
                    userInput = Integer.parseInt(scanner.nextLine());
                    validInput = true; // Boolean object set to true

                    if (userInput == 1) { // Set accountType to chequing if user input is equal to 1
                        accountType = "chequing";
                    } else if (userInput == 2) { // Set accountType to savings if user input is equal to 2
                        accountType = "savings";
                    } else { // User input is not equal to 1 or 2
                        System.out.println("Invalid input");
                    }
                } catch (NumberFormatException e) { // Invalid user input
                    System.out.println("Invalid input");
                }
            }
        }

        // Enter bank account balance
        System.out.println("\nEnter balance: ");

        // Loop while hasNextDouble is false
        while (!scanner.hasNextDouble())
        {
            System.out.println("Invalid input\nEnter balance:");
            scanner.next();
        }
        balance = scanner.nextDouble();

        // Create account object
        Account account = new Account();

        // Set bank account details using setter methods
        account.setAccountNumber(accountNumber);
        account.setAccountType(accountType);
        account.setName(name);
        account.setBalance(balance);

        // Loop while user input is not equal to 5
        while (userInput != 5) {
            System.out.println("\nJavaBank\n1. Account Details\n2. Balance\n3. Deposit\n4. Withdrawal\n5. exit ");
            try { // Attempt to read user input
                userInput = scanner.nextInt();

                // Switch statement
                switch (userInput) {
                    case 1: // Show account details (account number, type, name, balance)
                        userAccount(account);
                        break;
                    case 2: // Show account balance
                        checkBalance();
                        break;
                    case 3: // Deposit money into account
                        deposit(account);
                        break;
                    case 4: // Withdraw money from account
                        withdraw(account);
                        break;
                    case 5: // Exit
                        System.out.println("\nGoodbye");
                        break;
                    default: // Display error message for inputs with value greater than 5
                        System.out.println("Invalid input. please try again");
                        break;
                }
            } catch (InputMismatchException e) { // Invalid user input
                System.out.println("Sorry, an error has occurred");
                break;
            }
        }
        scanner.close(); // Close scanner object
    }

    // Boolean method to return string if it contains only letters
    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    // Method to print bank account details
    public static void userAccount(Account account) {
        System.out.println(account);
    }

    // Method to check bank account balance
    public static void checkBalance(){
        System.out.println("\nCurrent balance: $" + balance);
    }

    // Method to deposit money into bank account
    public static void deposit(Account account) {

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Create Boolean object and set it to false
        boolean validInput = false;

        // Loop while validInput is false
        while (!validInput) {
            System.out.print("\nEnter amount to deposit:\n");
            try { // attempt to read user input

                // Return new double value represented by user input
                double deposit = Double.parseDouble(scanner.nextLine());

                // Boolean object set to true
                validInput = true;

                if (deposit < 0) { // Amount to deposit is negative
                    System.out.println("Amount cannot be negative");
                    deposit(account);
                } else { // User input is valid and balance is updated
                    balance += deposit;
                    account.setBalance(balance);
                    checkBalance();
                }
            } catch (NumberFormatException e) { // Invalid user input
                System.out.println("Invalid input");
            }
        }
    }

    // Method to withdraw money from bank account
    public static void withdraw(Account account) {

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Create Boolean object and set it to false
        boolean validInput = false;

        // Loop while validInput is false
        while (!validInput) {
            System.out.print("\nEnter amount to withdraw:\n");
            try { // attempt to read user input

                // Return new double value represented by user input
                double withdraw = Double.parseDouble(scanner.nextLine());

                // Boolean object set to true
                validInput = true;

                if (withdraw < 0) { // Amount to withdraw is negative
                    System.out.println("Amount cannot be negative");
                    withdraw(account);
                } else if (withdraw > balance) { // Amount to withdraw exceeds balance
                    System.out.println("Insufficient funds");
                    withdraw(account);
                } else { // User input is valid and balance is updated
                    balance -= withdraw;
                    account.setBalance(balance);
                    checkBalance();
                }
            } catch (NumberFormatException e) { // Invalid input
                System.out.println("Invalid input");
            }
        }
    }
}
