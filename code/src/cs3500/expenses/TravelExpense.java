package cs3500.expenses;

import java.util.Objects;

public final class TravelExpense implements Expense {

    private final String name;
    private final double totalCost;
    private final double subtotal;

    public TravelExpense(String name, double totalCost, double taxedAmount) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name given to expense");
        }

        if (totalCost < 0 || taxedAmount < 0) {
            throw new IllegalArgumentException("Invalid costs given to expense");
        }

        this.name = name;
        this.totalCost = totalCost;
        this.subtotal = totalCost - taxedAmount;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public double totalCost() {
        return this.totalCost;
    }

    @Override
    public double subtotal() {
        return this.subtotal;
    }

    @Override
    public String prettyPrint() {
        return String.format("%s: $%.2f", this.name, this.totalCost);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof TravelExpense)) {
            return false;
        }

        TravelExpense that = (TravelExpense) other;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}