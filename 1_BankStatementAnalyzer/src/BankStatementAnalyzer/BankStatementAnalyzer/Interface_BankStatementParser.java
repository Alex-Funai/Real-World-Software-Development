package BankStatementAnalyzer;

import java.util.List;

public interface Interface_BankStatementParser {
    BankTransaction parseFrom (String line);
    List<BankTransaction> parseLinesFrom (List<String> lines);
}
