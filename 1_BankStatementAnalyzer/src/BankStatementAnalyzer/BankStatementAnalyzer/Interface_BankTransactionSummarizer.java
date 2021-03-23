
package BankStatementAnalyzer;


@FunctionalInterface
public interface Interface_BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}