package cs3500.expenses;

public interface Expense {
    String name();
    double totalCost();
    double subtotal();
    String prettyPrint(); // Add this method
}