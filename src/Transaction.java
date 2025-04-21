// Local Time (https://www.w3schools.com/java/java_date.asp)
import java.time.LocalDate;

public abstract class Transaction {
    protected String description;
    protected double amount;
    protected String category;
    protected LocalDate date;

    public Transaction(String description, double amount, String category, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Determines if the transaction is income (true) or expense (false).
    public abstract boolean isIncome();

    // Returns the description of the transaction.
    public String getDescription() {
        return description;
    }

    // Returns the amount of the transaction.
    public double getAmount() {
        return amount;
    }

    // Returns the category of the transaction.
    public String getCategory() {
        return category;
    }

    // Returns the date of the transaction.
    public LocalDate getDate() {
        return date;
    }
}

class Income extends Transaction {
    public Income(String description, double amount, String category, LocalDate date) {
        super(description, amount, category, date);
    }

    // Indicates that this transaction is income.
    @Override
    public boolean isIncome() {
        return true;
    }
}

class Expense extends Transaction {
    public Expense(String description, double amount, String category, LocalDate date) {
        super(description, amount, category, date);
    }

    // Indicates that this transaction is an expense.
    @Override
    public boolean isIncome() {
        return false;
    }
}
