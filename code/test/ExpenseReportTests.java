package cs3500.expenses;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExpenseReportTests {

    private TaxExemptExpenseReport report;
    private TravelExpense travelExpense;
    private BoardExpense boardExpense;
    private ConferenceExpense conferenceExpense;

    @Before
    public void setUp() {
        report = new TaxExemptExpenseReport();
        travelExpense = new TravelExpense("United Travel to Conference", 350.00, 26.25);
        boardExpense = new BoardExpense("Hilton Hotel Stay", 100.00, 4, 20.00);
        List<String> workshopNames = Arrays.asList("PLDI", "ARRAY", "ISMM");
        List<Double> workshopCosts = Arrays.asList(685.00, 100.00, 200.00);
        conferenceExpense = new ConferenceExpense("PLDI 2024", workshopNames, workshopCosts);
    }

    @Test
    public void testPrettyPrintExpense() {
        assertEquals("United Travel to Conference: $350.00", travelExpense.prettyPrint());
        assertEquals("Hilton Hotel Stay: $420.00", boardExpense.prettyPrint());
        String expectedConferencePrint = "PLDI 2024 Workshops\n" +
                "  PLDI: $685.00\n" +
                "  ARRAY: $100.00\n" +
                "  ISMM: $200.00\n" +
                "Total: $985.00";
        assertEquals(expectedConferencePrint, conferenceExpense.prettyPrint());
    }

    @Test
    public void testPrettyPrintExpenseReport() {
        report.addExpense(conferenceExpense);
        report.addExpense(travelExpense);
        report.addExpense(boardExpense);

        String expectedReportPrint = "Expenses:\n" +
                "  PLDI 2024 Workshops\n" +
                "    PLDI: $685.00\n" +
                "    ARRAY: $100.00\n" +
                "    ISMM: $200.00\n" +
                "  Total: $985.00\n" +
                "  United Travel to Conference: $350.00\n" +
                "  Hilton Hotel Stay: $420.00\n" +
                "Grand Total: $1755.00\n" +
                "Total Reimbursement: $1755.00";
        assertEquals(expectedReportPrint, report.prettyPrint());
    }

    @Test
    public void testEmptyExpenseReport() {
        String expectedReportPrint = "Expenses:\n" +
                "Grand Total: $0.00\n" +
                "Total Reimbursement: $0.00";
        assertEquals(expectedReportPrint, report.prettyPrint());
    }
}