package cs3500.expenses;

import java.util.List;
import java.util.Objects;

public final class ConferenceExpense implements Expense {

    private final String name;
    private final List<String> workshopNames;
    private final List<Double> workshopCosts;

    public ConferenceExpense(String name, List<String> workshopNames, List<Double> workshopCosts) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name given to expense");
        }

        if (workshopNames == null || workshopCosts == null || workshopNames.isEmpty() || workshopCosts.isEmpty()) {
            throw new IllegalArgumentException("Workshop lists cannot be null or empty");
        }

        if (workshopNames.size() != workshopCosts.size()) {
            throw new IllegalArgumentException("Workshop names and costs lists must be the same size");
        }

        for (String workshopName : workshopNames) {
            if (workshopName == null) {
                throw new IllegalArgumentException("Workshop name cannot be null");
            }
        }

        for (Double cost : workshopCosts) {
            if (cost == null || cost < 0) {
                throw new IllegalArgumentException("Workshop cost cannot be null or negative");
            }
        }

        for (int i = 0; i < workshopNames.size(); i++) {
            for (int j = i + 1; j < workshopNames.size(); j++) {
                if (workshopNames.get(i).equals(workshopNames.get(j))) {
                    throw new IllegalArgumentException("Duplicate workshop names are not allowed");
                }
            }
        }

        this.name = name;
        this.workshopNames = workshopNames;
        this.workshopCosts = workshopCosts;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public double totalCost() {
        return this.subtotal();
    }

    @Override
    public double subtotal() {
        double total = 0.0;
        for (Double cost : workshopCosts) {
            total += cost;
        }
        return total;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" Workshops\n");
        for (int i = 0; i < workshopNames.size(); i++) {
            sb.append("  ").append(workshopNames.get(i)).append(": $").append(String.format("%.2f", workshopCosts.get(i))).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", this.totalCost()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ConferenceExpense)) {
            return false;
        }

        ConferenceExpense that = (ConferenceExpense) other;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}