// Alexander Kitaro Funai -- March 23 2021
// Real-World Software Development -- Rauol-Gabriel Urma & Richard Warburton
// Chapter 2  and  Chapter 3 -- The Bank Statements Analyzer

package BankStatementAnalyzer;

/*  The HTMLExporter is an extension of API we have created with the base "Interface_Exporter" interface.
 *   This class utilizes the statement in ""Interface_Exporter", which is calling for the SummaryStatistics to be returned as a String object.
 *   Since our parent/base interface is implemented by this new HTMLExporter, the program assumes/utilizes that the information being
 *    handled will be in String format, thus we don't need to prelude our class to designate handling that data-type.
 *
 */
public class HtmlExporter implements Interface_Exporter {
    @Override
    public String export(final SummaryStatistics summaryStatistics) {

        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: " + summaryStatistics.getSum() + "</li>";
        result += "<li><strong>The average is</strong>: " + summaryStatistics.getAverage() + "</li>";
        result += "<li><strong>The max is</strong>: " + summaryStatistics.getMax() + "</li>";
        result += "<li><strong>The min is</strong>: " + summaryStatistics.getMin() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}