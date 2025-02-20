package cs3500.expenses;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some expenses
        TravelExpense travelExpense = new TravelExpense("United Travel to Conference", 350.00, 26.25);
        BoardExpense boardExpense = new BoardExpense("Hilton Hotel Stay", 100.00, 4, 20.00);
        List<String> workshopNames = Arrays.asList("PLDI", "ARRAY", "ISMM");
        List<Double> workshopCosts = Arrays.asList(685.00, 100.00, 200.00);
        ConferenceExpense conferenceExpense = new ConferenceExpense("PLDI 2024", workshopNames, workshopCosts);

        // Create an expense report
        TaxExemptExpenseReport report = new TaxExemptExpenseReport();
        report.addExpense(conferenceExpense);
        report.addExpense(travelExpense);
        report.addExpense(boardExpense);

        // Print the report
        System.out.println(report.prettyPrint());
    }
}