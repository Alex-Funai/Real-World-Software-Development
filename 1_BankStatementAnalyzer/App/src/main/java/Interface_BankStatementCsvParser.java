// Alexander Kitaro Funai -- March 20, 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer

// Interface_BankStatementCsvParser:

import java.util.List;

public interface Interface_BankStatementCsvParser {

    List<BankTransaction> parseLinesFromCSV(List<String> lines);
}
