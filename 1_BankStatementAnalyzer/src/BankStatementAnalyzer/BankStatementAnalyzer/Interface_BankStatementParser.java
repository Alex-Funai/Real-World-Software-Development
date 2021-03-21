// Alexander Kitaro Funai -- March 20, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2 -- The Bank Statements Analyzer

// Interface_BankStatementAnalyzer:

package BankStatementAnalyzer;

import java.util.List;

public interface Interface_BankStatementParser {
    BankTransaction parseFrom (String line);
    List<BankTransaction> parseLinesFrom (List <String> lines);
}

