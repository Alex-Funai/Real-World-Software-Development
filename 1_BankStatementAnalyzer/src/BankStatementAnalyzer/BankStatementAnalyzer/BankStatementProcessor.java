package BankStatementAnalyzer;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    // Method for calculating the total cumulative value of all transactions:
    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    // Method for calculating the cumulative value of transactions in a specified date.month [col1].
    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    // Method for calculating the cumulative value of transactions, of a specified category [col2].
    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    // Method for finding/filtering /searching bank transactions  >= a specified value:
    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    // Method for finding/filtering/searching bank transactions in a specified month:
    public List<BankTransaction> findTransactionsInMonth(final Month month) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    // Inclusive method for finding/filtering/searching bank transactions in a specific month &  values above a speciied mark.
    public List<BankTransaction> findTransactionsInMonthAndGreaterThanEqual(final Month month, final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month && bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
    /* This method is less desireable, because it combines multiple operations of a bank transaction.
     *  This method is less desireable, because the "selection-logic" is coupled w ith the "iteration-logic".
     *  If the previous 2 test methods stand, then this is redundant.
     *
     *  [SOLUTION]: Implement a BankTransactionFilter interface to couple the BankTransaction class.
     *  The BankTransactionFilter we'll entail all the properties of the BankTransaction class, and return a boolean.
     *  This would be a functional interface.
     *  [Functional Interface] --- A functional interface, is an interface that only contains a single abstract method.
     *  A functional interface is notated by using the "FunctionalInterface" annotation to clarify the interface's intent.
     */

    // Flexible findTransactions() method using "Open/Closed Principle" >> Coupled w/ "Interface_BankTransactionFilter".
    public List<BankTransaction> findTransactions(final BankStatementAnalyzer.BankTransactionProcessor.Interface_BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
                ;
            }
        }
        return result;
    }
}