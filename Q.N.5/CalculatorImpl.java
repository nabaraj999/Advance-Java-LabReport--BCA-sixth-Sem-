import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    protected CalculatorImpl() throws RemoteException {
        super();  // Required for UnicastRemoteObject
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        System.out.println("add called: " + a + " + " + b);
        return a + b;
    }

    @Override
    public double subtract(double a, double b) throws RemoteException {
        System.out.println("subtract called: " + a + " - " + b);
        return a - b;
    }

    @Override
    public double multiply(double a, double b) throws RemoteException {
        System.out.println("multiply called: " + a + " * " + b);
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Division by zero!");
        }
        System.out.println("divide called: " + a + " / " + b);
        return a / b;
    }
}