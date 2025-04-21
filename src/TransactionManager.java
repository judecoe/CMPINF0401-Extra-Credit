import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class TransactionManager {
    private static final String FILE_NAME = "transactions.txt";

    // Saves all transactions to a file.
    public static void saveTransactions(BudgetTracker tracker) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Transaction t : tracker.getAllTransactions()) {
                writer.write(String.format("%s,%f,%s,%s,%s\n",
                        t.isIncome() ? "Income" : "Expense",
                        t.getAmount(),
                        t.getCategory(),
                        t.getDate(),
                        t.getDescription()));
            }
        }
    }

    // Loads transactions from a file into the tracker.
    public static void loadTransactions(BudgetTracker tracker) throws IOException {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String type = parts[0];
                double amount = Double.parseDouble(parts[1]);
                String category = parts[2];
                LocalDate date = LocalDate.parse(parts[3]);
                String description = parts[4];

                if (type.equals("Income")) {
                    tracker.addTransaction(new Income(description, amount, category, date));
                } else {
                    tracker.addTransaction(new Expense(description, amount, category, date));
                }
            }
        }
    }
}
