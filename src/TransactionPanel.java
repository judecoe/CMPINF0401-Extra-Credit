import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TransactionPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    // Initializes the panel with a scrollable table to display transactions.
    public TransactionPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tableModel = new DefaultTableModel(new String[]{"Type", "Amount", "Category", "Date", "Description"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table));
    }

    // Updates the table with the latest list of transactions.
    public void updateTransactions(List<Transaction> transactions) {
        tableModel.setRowCount(0);
        for (Transaction t : transactions) {
            tableModel.addRow(new Object[]{
                    t.isIncome() ? "Income" : "Expense",
                    t.getAmount(),
                    t.getCategory(),
                    t.getDate(),
                    t.getDescription()
            });
        }
    }
}
