/* Description: */
/* The following program prompts the user to enter a password. The program checks to see if the password contains
   at least one uppercase letter, one special character, and one number. If the password meets these criteria, then
   the password is valid. If not, the user is prompted to try again until they provide a valid password. */

package password_validator;

import java.util.Scanner; // Import Scanner class

// Create class named passwordValidator
public class passwordValidator {

    // Create static Boolean method named validPassword
    public static boolean validPassword(String username, String password) {

        // Set Boolean to true
        boolean isValid = true;

        // Checks to see if password is less than 8 characters long
        if(password.length() < 8){

            // Set Boolean to false
            isValid = false;
            System.out.println("The password must be at least 8 characters long");
        }

        // Checks to see if the password does not contain an uppercase letter by comparing the password
        // to a version of the password that is all lowercase
        if(password.equals(password.toLowerCase())){

            // Set Boolean to false
            isValid = false;
            System.out.println("The password must include an uppercase letter");
        }

        // Checks to see if the password does not contain a special character by matching it with
        // the regular expression a-zA-Z0-9
        if(password.matches("[a-zA-Z0-9]*")){

            // Set Boolean to false
            isValid = false;
            System.out.println("The password must include a special character");
        }

        // Checks to see if password does not contain a number by matching it with the regular
        // expression .*\\d.*
        if(!password.matches(".*\\d.*")){

            // Set Boolean to false
            isValid = false;
            System.out.println("The password must include a number");
        }

        // Check to see if the password contains the username by converting both username and
        // password to uppercase
        if(password.toUpperCase().contains(username.toUpperCase())){

            // Set Boolean to false
            isValid = false;
            System.out.println("The password cannot contain your username");
        }

        return isValid; // Return Boolean value
    }

    // Create main() method
    public static void main(String[] args) {

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a username
        System.out.println("Please enter a username: ");
        String username = scanner.nextLine();

        // Prompt user to enter a password
        System.out.println("\nPlease enter a password: ");
        String password = scanner.nextLine();

        // Create Boolean object and assign it the validPassword method
        boolean result = validPassword(username, password);

        // Loop while result is false
        while (!result) {

            // Prompt user to enter a password again
            System.out.println("\nTry again");
            System.out.println("Please enter a new password: ");
            password = scanner.nextLine();
            result = validPassword(username, password);
        }

        System.out.println("\nThe password is valid");
        scanner.close(); // close Scanner object
    }
}