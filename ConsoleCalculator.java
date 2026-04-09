import java.util.Scanner;

public class ConsoleCalculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        double num1 = 0.0;
        double num2 = 0.0;
        double result = 0.0;
        char choice = 'y';

        while (choice == 'y' || choice == 'Y') {

            System.out.println("\n--- Java Console Calculator ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");

            System.out.print("Choose an operation (1-4): ");
            if (sc.hasNextInt()) {
                option = sc.nextInt();
            } else {
                System.out.println("Invalid input.");
                sc.next(); 
                continue;
            }

            System.out.print("Enter first number: ");
            if (sc.hasNextDouble()) {
                num1 = sc.nextDouble();
            } else {
                System.out.println("Invalid input.");
                sc.next();
                continue;
            }

            System.out.print("Enter second number: ");
            if (sc.hasNextDouble()) {
                num2 = sc.nextDouble();
            } else {
                System.out.println("Invalid input.");
                sc.next();
                continue;
            }

            switch (option) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    result = divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            System.out.println("Result: " + result);

            System.out.print("Do you want to perform another calculation? (y/n): ");
            choice = sc.next().charAt(0);
        }

        sc.close();
        System.out.println("Calculator exited.");
    }
}