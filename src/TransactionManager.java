import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class TransactionManager {
    private static final String FILE_NAME = "transactions.txt";

    // Saves all transactions to a file
    public static void saveTransactions(BudgetTracker tracker) throws IOException {
        FileWriter writer = new FileWriter(FILE_NAME); // FileWriter to write data to the file (https://www.geeksforgeeks.org/filewriter-class-in-java/)
        for (Transaction t : tracker.getAllTransactions()) {
            String type = t.isIncome() ? "Income" : "Expense"; // Determine if transaction is income or expense
            writer.write(type + "," + t.getAmount() + "," + t.getCategory() + "," + t.getDate() + "," + t.getDescription() + "\n");
        }
        writer.close();
    }

    // Loads transactions from a file into the tracker
    public static void loadTransactions(BudgetTracker tracker) throws IOException {
        Scanner scanner = new Scanner(new File(FILE_NAME)); // Scanner to read data from the file
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(","); // Split the line into transaction details
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);
            String category = parts[2];
            LocalDate date = LocalDate.parse(parts[3]);
            String description = parts[4];

            Transaction transaction;
            if (type.equals("Income")) {
                transaction = new Income(description, amount, category, date);
            } else {
                transaction = new Expense(description, amount, category, date);
            }
            tracker.addTransaction(transaction);
        }
        scanner.close();
    }
}
