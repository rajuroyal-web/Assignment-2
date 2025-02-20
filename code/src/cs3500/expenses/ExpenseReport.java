package cs3500.expenses;

/**
 * Behaviors for a reimbursement form. A reimbursement form
 * is a collection of unique expenses in US dollars and cents.
 * These are normally submitted after money has been spent so a
 * larger entity (like a university or company) can refund the non-taxed amount
 * spent by one of their employees.
 * DO NOT EDIT THIS CODE EXCEPT TO ADD METHODS MENTIONED IN THE ASSIGNMENT!!
 */
public interface ExpenseReport {

  /**
   * Adds a single expense to the report.
   * @param expense the expense to add to the report
   * @throws IllegalArgumentException if expense is null or already in the report
   */
  void addExpense(Expense expense);

  /**
   * Returns the amount of money that can be reimbursed with the expenses in the form.
   * Note this number can have more than two decimal places to prevent rounding error.
   * @return the total amount of money that can be repaid
   */
  double totalReimbursement();

  /**
   * Returns the total cost of all expenses, including any tax paid on them.
   * Note this number can have more than two decimal places to prevent rounding error.
   * @return the total cost of all expenses
   */
  double totalCost();

  /**
   * Returns the first expense that has the exact given name.
   * @param name the name of the expense to find
   * @return the first expense found with that name
   * @throws IllegalStateException if no expense with the given name can be found
   */
  Expense findItemByName(String name);
  
   String prettyPrint();
}
