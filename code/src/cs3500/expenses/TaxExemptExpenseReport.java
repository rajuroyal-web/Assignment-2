package cs3500.expenses;

import java.util.ArrayList;
import java.util.List;

public final class TaxExemptExpenseReport implements ExpenseReport {

    private final List<Expense> expensesToReimburse;

    public TaxExemptExpenseReport() {
        this.expensesToReimburse = new ArrayList<>();
    }

    @Override
    public void addExpense(Expense expense) {
        if (expense == null) {
            throw new IllegalArgumentException("Cannot add null expense");
        }

        if (!this.expensesToReimburse.contains(expense)) {
            this.expensesToReimburse.add(expense);
        } else {
            throw new IllegalArgumentException("Cannot add same expense twice");
        }
    }

    @Override
    public double totalReimbursement() {
        double answer = 0.0;
        for (Expense expense : expensesToReimburse) {
            answer += expense.subtotal();
        }
        return answer;
    }

    @Override
    public double totalCost() {
        double answer = 0.0;
        for (Expense expense : expensesToReimburse) {
            answer += expense.totalCost();
        }
        return answer;
    }

    @Override
    public Expense findItemByName(String name) {
        for (Expense expense : expensesToReimburse) {
            if (expense.name().equals(name)) {
                return expense;
            }
        }
        throw new IllegalStateException("No such expense called \"" + name + "\"");
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("Expenses:\n");
        for (Expense expense : expensesToReimburse) {
            sb.append("  ").append(expense.prettyPrint()).append("\n");
        }
        sb.append(String.format("Grand Total: $%.2f\n", this.totalCost()));
        sb.append(String.format("Total Reimbursement: $%.2f", this.totalReimbursement()));
        return sb.toString();
    }
}