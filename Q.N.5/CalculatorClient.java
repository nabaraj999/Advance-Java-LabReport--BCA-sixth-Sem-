import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Get registry (localhost:1099 by default)
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup the remote object
            Calculator calc = (Calculator) registry.lookup("CalculatorService");

            System.out.println("Connected to remote Calculator!");

            // Call remote methods
            double num1 = 20.0;
            double num2 = 8.0;

            System.out.println(num1 + " + " + num2 + " = " + calc.add(num1, num2));
            System.out.println(num1 + " - " + num2 + " = " + calc.subtract(num1, num2));
            System.out.println(num1 + " * " + num2 + " = " + calc.multiply(num1, num2));
            System.out.println(num1 + " / " + num2 + " = " + calc.divide(num1, num2));

            // Test division by zero
            try {
                System.out.println("10 / 0 = " + calc.divide(10, 0));
            } catch (Exception e) {
                System.out.println("Caught: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}