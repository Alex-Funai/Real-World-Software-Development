package BankStatementAnalyzer.Main.Resources;

import java.util.List;

public interface Interface_BankStatementCsvParser {
    List<BankTransaction> parseLinesFromCSV(List<String> lines);
}
