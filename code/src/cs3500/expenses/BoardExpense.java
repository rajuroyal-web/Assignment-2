package cs3500.expenses;

import java.util.Objects;

public final class BoardExpense implements Expense {

    private final String name;
    private final double totalCost;
    private final double rate;
    private final int duration;

    public BoardExpense(String name, double rate, int duration, double taxedAmount) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name given to expense");
        }

        if (rate < 0 || duration <= 0 || taxedAmount < 0) {
            throw new IllegalArgumentException("Invalid costs given to expense");
        }

        this.name = name;
        this.rate = rate;
        this.duration = duration;
        this.totalCost = this.subtotal() + taxedAmount;
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
        return this.rate * duration;
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

        if (!(other instanceof BoardExpense)) {
            return false;
        }

        BoardExpense that = (BoardExpense) other;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}