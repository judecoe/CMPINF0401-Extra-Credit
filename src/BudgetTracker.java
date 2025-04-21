import java.util.ArrayList;
import java.util.List;

public class BudgetTracker {
    private List<Transaction> transactions;

    public BudgetTracker() {
        transactions = new ArrayList<>();
    }

    // Adds a transaction to the list
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Calculates the total income from all transactions
    public double getTotalIncome() {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.isIncome()) {
                total += t.getAmount();
            }
        }
        return total;
    }

    // Calculates the total expenses from all transactions
    public double getTotalExpenses() {
        double total = 0;
        for (Transaction t : transactions) {
            if (!t.isIncome()) {
                total += t.getAmount();
            }
        }
        return total;
    }

    // Calculates the balance by subtracting expenses from income
    public double getBalance() {
        return getTotalIncome() - getTotalExpenses();
    }

    // Returns a copy of the list of all transactions.
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}
