package elevate.task1ccalculator;

import java.util.Scanner;

/* -----------------------------------------------------------
   POJO (Plain Old Java Object) that *knows how to calculate*.
   Each object holds two numbers and can perform operations
   on those numbers through instance methods.
   ----------------------------------------------------------- */
class calculatorClass {

    private double a;
    private double b;

    // 📌 Constructor: sets the two numbers when we create the object
    calculatorClass(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /* ---------- Basic Operations ---------- */
    double add()       { return a + b; }
    double subtract()  { return a - b; }
    double multiply()  { return a * b; }

    double divide() {
        if (b == 0) {
            // We let the caller decide how to deal with “not-a-number”
            System.out.println("⚠️  Error: Division by zero!");
            return Double.NaN;
        }
        return a / b;
    }
}

/* -----------------------------------------------------------
   “Driver” class that owns main() and handles all user I/O.
   ----------------------------------------------------------- */
public class Calculator {

    // 💡 A helper method that uses a *switch* to delegate work
    //    to the correct Calculator method
    private static double performOperation(int choice, calculatorClass calc) {
        switch (choice) {
            case 1:  // Addition
                return calc.add();
            case 2:  // Subtraction
                return calc.subtract();
            case 3:  // Multiplication
                return calc.multiply();
            case 4:  // Division
                return calc.divide();
            default: // Defensive programming: unreachable, but safe
                System.out.println("Invalid option!");
                return Double.NaN;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("  Welcome to the OOP Java Console Calculator!");

        // Main program loop
        while (keepRunning) {
            // 1️⃣  Show menu
            System.out.println("\nChoose an operation:");
            System.out.println("1 ➜ Addition (+)");
            System.out.println("2 ➜ Subtraction (-)");
            System.out.println("3 ➜ Multiplication (*)");
            System.out.println("4 ➜ Division (/)");
            System.out.println("5 ➜ Exit");
            System.out.print("Your choice: ");

            int choice = sc.nextInt();  // read menu option

            if (choice == 5) {          // user chose Exit
                keepRunning = false;
                System.out.println("\n  Thanks for using the calculatorClass. Goodbye!");
                break;
            }

            // 2️⃣  Ask for the two numbers
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            // 3️⃣  Build a Calculator *object* with those numbers
            calculatorClass calc = new calculatorClass(num1, num2);

            // 4️⃣  Let performOperation() and its switch pick the method
            double result = performOperation(choice, calc);

            // 5️⃣  Only print if it’s a valid number (not NaN)
            if (!Double.isNaN(result)) {
                System.out.println("  Result = " + result);
            }
        }

        sc.close();
    }
}

