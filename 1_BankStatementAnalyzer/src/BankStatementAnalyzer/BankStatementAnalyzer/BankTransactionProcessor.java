package BankStatementAnalyzer;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;




public class BankTransactionProcessor  {

    private final List <BankTransaction> bankTransactions;
    double result = 0;

public BankTransactionProcessor (final List <BankTransaction> bankTransactions) {
    this.bankTransactions = bankTransactions;
}


    public double summarizeTransactions (final Interface_BankTransactionSummarizer bankTransactionSummarizer) {
        for (final BankTransaction bankTransaction: bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalInMonth (final Month month) {
        return summarizeTransactions ((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? acc  + bankTransaction.getAmount() : acc);
    }
    // ....

    public List<BankTransaction> findTransactions (final Interface_BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return bankTransactions;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }

    // ...

    @FunctionalInterface
    interface Interface_BankTransactionSummarizer {
        double summarize (double accumulator, BankTransaction bankTransaction);
    }

    @FunctionalInterface        // [Functional Interface] --- An interface containing only a single abstract method.
        interface Interface_BankTransactionFilter {
        boolean test (BankTransaction bankTransaction);
    }

    @FunctionalInterface
    interface CalculateTotalInMonth {
        double calculateTotalInMonth (Month month);
    }
}

