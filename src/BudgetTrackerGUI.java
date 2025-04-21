// JPanel (https://www.geeksforgeeks.org/java-swing-jpanel-with-examples/)
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class BudgetTrackerGUI extends JFrame {
    private BudgetTracker tracker;
    private TransactionPanel transactionPanel;
    
    // Sets up the GUI with panels for dashboard, adding transactions, history, and file operations
    public BudgetTrackerGUI() { 
        tracker = new BudgetTracker();
        transactionPanel = new TransactionPanel();

        setTitle("Personal Budget Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Dashboard Panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new GridLayout(1, 3));
        JLabel incomeLabel = new JLabel("Total Income: $0.00");
        JLabel expenseLabel = new JLabel("Total Expenses: $0.00");
        JLabel balanceLabel = new JLabel("Balance: $0.00");
        dashboardPanel.add(incomeLabel);
        dashboardPanel.add(expenseLabel);
        dashboardPanel.add(balanceLabel);

        // Add Transaction Panel
        JPanel addTransactionPanel = new JPanel();
        addTransactionPanel.setLayout(new GridLayout(5, 2));
        // JTextField (https://www.geeksforgeeks.org/java-swing-jtextfield/)
        JTextField descriptionField = new JTextField();
        JTextField amountField = new JTextField();
        // JComboBox Information (https://www.geeksforgeeks.org/java-swing-jcombobox-examples/)
        JComboBox<String> typeBox = new JComboBox<>(new String[]{"Income", "Expense"});
        JTextField categoryField = new JTextField();
        JButton addButton = new JButton("Add Transaction");
        addTransactionPanel.add(new JLabel("Description:"));
        addTransactionPanel.add(descriptionField);
        addTransactionPanel.add(new JLabel("Amount:"));
        addTransactionPanel.add(amountField);
        addTransactionPanel.add(new JLabel("Type:"));
        addTransactionPanel.add(typeBox);
        addTransactionPanel.add(new JLabel("Category:"));
        addTransactionPanel.add(categoryField);
        addTransactionPanel.add(new JLabel());
        addTransactionPanel.add(addButton);

        // History Panel
        JPanel historyPanel = new JPanel(new BorderLayout());
        historyPanel.add(transactionPanel, BorderLayout.CENTER);

        // File Panel
        JPanel filePanel = new JPanel();
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        filePanel.add(saveButton);
        filePanel.add(loadButton);

        // Add panels to the frame (https://www.geeksforgeeks.org/java-awt-borderlayout-class/)
        // Did not know about BorderLayout, nor the NORTH, CENTER, etc.
        add(dashboardPanel, BorderLayout.NORTH);
        add(addTransactionPanel, BorderLayout.CENTER);
        add(historyPanel, BorderLayout.SOUTH);
        add(filePanel, BorderLayout.PAGE_END);

        // Adds a new transaction based on user input and updates the dashboard and history
        addButton.addActionListener(_ -> {
            String description = descriptionField.getText();
            double amount = Double.parseDouble(amountField.getText());
            String type = (String) typeBox.getSelectedItem();
            String category = categoryField.getText();
            Transaction transaction = type.equals("Income")
                    ? new Income(description, amount, category, LocalDate.now())
                    : new Expense(description, amount, category, LocalDate.now());
            tracker.addTransaction(transaction);
            updateDashboard(incomeLabel, expenseLabel, balanceLabel);
            transactionPanel.updateTransactions(tracker.getAllTransactions());
        });

        // Saves all transactions to a file
        saveButton.addActionListener(_ -> {
            try {
                TransactionManager.saveTransactions(tracker);
                JOptionPane.showMessageDialog(this, "Transactions saved successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saving transactions: " + ex.getMessage());
            }
        });

        // Loads transactions from a file and updates the dashboard and history
        loadButton.addActionListener(_ -> {
            try {
                TransactionManager.loadTransactions(tracker);
                updateDashboard(incomeLabel, expenseLabel, balanceLabel);
                transactionPanel.updateTransactions(tracker.getAllTransactions());
                JOptionPane.showMessageDialog(this, "Transactions loaded successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error loading transactions: " + ex.getMessage());
            }
        });

        pack();
        setSize(800, 600);
        setVisible(true);
    }
    
    // Updates the dashboard labels with the latest totals.
    private void updateDashboard(JLabel incomeLabel, JLabel expenseLabel, JLabel balanceLabel) { 
        incomeLabel.setText(String.format("Total Income: $%.2f", tracker.getTotalIncome()));
        expenseLabel.setText(String.format("Total Expenses: $%.2f", tracker.getTotalExpenses()));
        balanceLabel.setText(String.format("Balance: $%.2f", tracker.getBalance()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BudgetTrackerGUI::new);
    }
}
