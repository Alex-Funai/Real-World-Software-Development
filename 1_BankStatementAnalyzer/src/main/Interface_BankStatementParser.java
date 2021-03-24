// Alexander Kitaro Funai -- March 23 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer


import java.util.List;

public interface Interface_BankStatementParser {
    BankTransaction parseFrom (String line);
    List<BankTransaction> parseLinesFrom (List<String> lines);
}
