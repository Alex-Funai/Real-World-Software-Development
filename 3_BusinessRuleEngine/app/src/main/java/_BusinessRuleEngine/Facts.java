///////////////////////////////////////////////////////////////////////////////
// Main Class File:
// File: Facts
// Date: March 31, 2021
//
// Author: Alexander Kitaro Funai
// Email: alexanderfunai@protonmail.com
// Book Author: Rauol-Gabriel Urma & Richard Warburton
// Book Title: Real-World Software Development
// Book Section: Chapter 5
//
////////////////////////////////////////////////////////////////////////////////
// Online sources: "github.com/Iteratr-Learning/Real-World-Software-Development"
////////////////////////////////////////////////////////////////////////////////



package _BusinessRuleEngine;
import java.util.HashMap;
import java.util.Map;

public class Facts {
    

    private final Map<String, String> facts = new HashMap<>();

    public String getFact (String name) {

        return this.facts.get (name);
    }

    public void addFact (String name, String value) {

        this.facts.put (name, value);
    }

    public void setFact (final String name, final String value) {

        this.facts.put (name, value);
    }
}
