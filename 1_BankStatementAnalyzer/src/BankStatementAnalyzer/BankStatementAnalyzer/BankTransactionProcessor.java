package BankStatementAnalyzer;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class BankTransactionProcessor {
    private final List<BankTransaction> bankTransactions;


    public BankTransactionProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(final Interface_BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);
    }
    // ....


    //[3.1]  Inclusive method for finding/filtering/searching bank transactions in a specific month &  values above a speciied mark.
    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    //[3.2] Find bank transactions in a certain month.
    public List<BankTransaction> findTransactionsInMonth(final Month month) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    //[3.3] Find bank transactions in a certain month and over a certain amount.
    public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month && bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    // [3.5]  Flexible findTransactions() method using Open/Closed principle.
    public List<BankTransaction> findTransactions(final Interface_BankTransactionFilter interfaceBankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (interfaceBankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return bankTransactions;
    }
}

/*    // Method for finding/filtering /searching bank transactions  >= a specified value:
    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }*/





    // ...


