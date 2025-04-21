# Self-Evaluation: Personal Budget Tracker GUI

## Project Overview

This project is a GUI-based personal budget tracker application designed to help users manage their finances.

### Key Features

- **Dashboard**: Displays total income, total expenses, and the current balance.
- **Add Transactions**: A panel where users can input transaction details, including description, amount, type (income/expense), and category.
- **Transaction History**: A panel that lists all transactions for easy reference.
- **File Operations**: Save and load transactions using the TransactionManager.
- **Real-Time Updates**: The dashboard and transaction history refresh automatically whenever a transaction is added, saved, or loaded.

## Implementation Details

### GUI Design

The application uses a JPanel with BorderLayout to organize the interface into distinct sections:

- A dashboard for financial summaries.
- A panel for adding new transactions.
- A history panel to display past transactions.
- A file operations panel for saving and loading data.

Interactive components like JTextField, JComboBox, and JButton make the interface user-friendly.

### Transaction Management

Transactions are categorized as either income or expense and stored in a BudgetTracker object. The TransactionManager handles saving and loading transactions to and from files.

### Dynamic Updates

The dashboard updates instantly to reflect changes in income, expenses, and balance. Similarly, the transaction history panel refreshes to show the latest data.

## Challenges & Solutions

- **Organizing the Layout**: Initially, I struggled with arranging the GUI components. Learning and applying BorderLayout and GridLayout helped resolve this issue.
- **Parsing User Input**: Converting text input to numerical values (e.g., doubles) was tricky at first. I addressed this by adding input validation.

## What I Learned

- Before this project, I had limited experience with advanced Swing components like JComboBox and GridLayout. Now, I feel confident using them to create complex GUIs.
- I also learned how to handle file operations in Java, which was a new skill for me.

## Self-Assessment

- **Effort**: I dedicated around 8-10 hours to this project, including research, coding, and debugging.
- **Challenges Overcome**: I successfully built a functional and intuitive GUI, learned new Swing components, and implemented file operations.
- **Points Justification**: I believe this project deserves 20 points due to the well-structured GUI, file handling, and real-time updates to the dashboard and transaction history.
