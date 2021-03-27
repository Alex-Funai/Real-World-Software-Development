// Alexander Kitaro Funai -- March 23 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer

@FunctionalInterface
public interface Interface_BankTransactionSummarizer {

    double summarize(double accumulator, BankTransaction bankTransaction);
}