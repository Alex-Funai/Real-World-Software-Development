///////////////////////////////////////////////////////////////////////////////
// Main Class File: Main_Application.java
// File: interface.Interface_Exporter.java
// Date: March 23, 2021
//
// Programmer: Alexander Kitaro Funai > alexanderfunai@protonmail.com
// Book: Real World Software Development
// Author(s): Rauol-Gabriel Urma & Richard Warburton
// Section(s): Chapters 2-3
///////////////////////////////////////////////////////////////////////////////

package _bankStatementAnalyzer;

/**
 * class.HTMLExporter is an extension of API we have created with the base "Interface_Exporter" interface.
 * This class utilizes the statement in ""Interface_Exporter", which is calling for the SummaryStatistics to be
 * returned as a String object. Since our parent/base interface is implemented by this new HTMLExporter,
 * the program assumes/utilizes that the information being handled will be in String format,
 * thus we won't need to utilize to multiple exporters when calling in 'class.Main_Application'.
 *
 * @see _bankStatementAnalyzer.Interface_Exporter for
 *
 * <p> Bugs: not enough.
 *
 * @author Raoul-Gabriel Urma & Richard Warburton
 */
public class Exporter_HTML implements Interface_Exporter {

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