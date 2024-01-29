package edu.pasadena.cs.cs03b;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        int option=0;
        Scanner userInput = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1) Add numbers in different bases?");
        System.out.println("2) calculate tuition?");
        option = userInput.nextInt();


        if(option == 1){
        int choice = 0;
        int m = 0;
        String a = " ";
        String b = " ";
        char temp = 0;
        int t;
        int holder;

        // Display menu for choosing bases
        System.out.println("What bases did you want to add together?");
        System.out.println("1) base 10");
        System.out.println("2) base 2");
        System.out.println("3) base 16");
        System.out.println("Input a number from 1-3: ");
        choice = userInput.nextInt();

        // Check user choice and call the corresponding base addition method
        if (choice == 1) {
            System.out.println("Input the number size: ");
            m = userInput.nextInt();
            System.out.println("Input a number: ");
            a = userInput.next();
            System.out.println("Input a number: ");
            b = userInput.next();
            baseTen(a, b, m);
        } else if (choice == 2) {
            System.out.println("Input the number size: ");
            m = userInput.nextInt();
            System.out.println("Input a number: ");
            a = userInput.next();
            System.out.println("Input a number: ");
            b = userInput.next();
            baseTwo(a, b, m);
        } else if (choice == 3) {
            System.out.println("Input the number size: ");
            m = userInput.nextInt();
            System.out.println("Input a number: ");
            a = userInput.next();
            System.out.println("Input a number: ");
            b = userInput.next();
            hexAddition(a, b, m);
        } else {
            System.out.println("Invalid choice. Input a number from 1-3.");
            choice = userInput.nextInt();
        }
    }else if (option == 2){
 // Variables to store user input and calculated values
 double tuitionCost;
 double tuitionFourYears, interest;

 // Scanner for user input

 // Prompt the user to enter the tuition cost
 System.out.println("Enter the tuition cost:");
 tuitionCost = userInput.nextDouble();

 // Calculate tuition in ten years using compound interest formula
 double tuitionInTenYears = tuitionCost * Math.pow(1 + 0.05, 10);

 // Prompt the user to enter the interest rate
 System.out.println("Enter the interest rate: ");
 interest = userInput.nextDouble();

 // Output the calculated tuition in ten years and the four-year tuition in ten years
 System.out.println("Tuition in ten years is : " + tuitionInTenYears);
 System.out.println("The four-year tuition in ten years is : " + tuitionFourYears(tuitionInTenYears, interest));
        }
        
    
    }

    // Method to calculate four-year tuition based on compound interest
    public static double tuitionFourYears(double tuitionCost, double interest) {
        double fourYears = tuitionCost;

        // Loop to calculate tuition for each of the four years
        for (int x = 0; x < 3; x++) {
            tuitionCost += (tuitionCost * interest);
            fourYears += tuitionCost;
        }

        // Return the total four-year tuition
        return fourYears;
    }

    
    // Method for base 10 addition
    public static String baseTen(String a, String b, int m) {
        int carry = 0;
        int total = 0;
        String result = "";

        for (int j = m - 1; j >= 0; j--) {
            int numberA = a.charAt(j) - '0';
            int numberB = b.charAt(j) - '0';
            total = numberA + numberB + carry;

            if (total > 9) {
                total -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            // Prepend the current digit to the result
            result = total + result;
        }

        // If there's a carry after all digits are processed
        if (carry > 0) {
            result = carry + result;
        }

        System.out.println("Sum in base 10: " + result);
        return result;
    }

    // Method for base 2 addition
    public static String baseTwo(String a, String b, int m) {
        int carry = 0;
        int total = 0;
        String result = "";

        for (int j = m - 1; j >= 0; j--) {
            int numberA = a.charAt(j) - '0';
            int numberB = b.charAt(j) - '0';
            total = numberA + numberB + carry;

            if (total > 1) {
                total -= 2;
                carry = 1;
            } else {
                carry = 0;
            }

            // Prepend the current digit to the result
            result = total + result;
        }

        // If there's a carry after all digits are processed
        if (carry > 0) {
            result = carry + result;
        }

        System.out.println("Sum in base 2: " + result);
        return result;
    }

    // Method for base 16 addition
    public static int[] hexAddition(String x, String y, int m) {
        int total;
        int base = 16;
        int[] numberA = new int[m];

        // Convert characters in reverse order to integer array
        for (int i = m - 1, j = 0; i >= 0; i--, j++) {
            numberA[j] = Character.digit(x.charAt(i), 16);
        }

        int[] numberB = new int[m];

        // Convert characters in reverse order to integer array
        for (int i = m - 1, j = 0; i >= 0; i--, j++) {
            numberB[j] = Character.digit(y.charAt(i), 16);
        }

        int[] c = new int[m + 1];
        int carry = 0;

        // Perform addition
        for (int i = 0; i < m; i++) {
            total = numberA[i] + numberB[i] + carry;
            c[i] = total % base;
            carry = total / base;
        }

        if (carry > 0) {
            c[m] = carry;
        }

        // Print the result
        System.out.print("The sum is: 0X");
        for (int i = m; i >= 0; i--) {
            if (!(c[i] == 0 && i == m)) {
                System.out.printf("%X", c[i]);
            }
        }
        return c;
    }

}



