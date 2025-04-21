import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TransactionPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    // Initializes the panel with a scrollable table to display transactions
    public TransactionPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Use vertical layout for components
        tableModel = new DefaultTableModel(new String[]{"Type", "Amount", "Category", "Date", "Description"}, 0); // Define table columns
        table = new JTable(tableModel); // Create table with the model
        add(new JScrollPane(table)); // Add table inside a scroll pane
    }

    // Updates the table with the latest list of transactions
    public void updateTransactions(List<Transaction> transactions) {
        tableModel.setRowCount(0); // Clear existing rows
        for (Transaction t : transactions) {
            String type = t.isIncome() ? "Income" : "Expense"; // Determine transaction type
            Object[] row = {type, t.getAmount(), t.getCategory(), t.getDate(), t.getDescription()}; // Create row data
            tableModel.addRow(row); 
        }
    }
}
