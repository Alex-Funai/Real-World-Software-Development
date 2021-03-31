///////////////////////////////////////////////////////////////////////////////
// Main Class File:
// File: ConditionalAction.java
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

public interface ConditionalAction {
    void perform (Facts facts);

    boolean evaluate (Facts facts);




}
