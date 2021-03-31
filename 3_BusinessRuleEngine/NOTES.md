<!--- 
Alexander Kitaro Funai
March 28, 2021
https://www.alexanderfunai.com
Real World Software Development
Rauol-Gabriel Urma & Ricahrd Warburon
-->

# Chapter 5 Notes:

## Test-Driven-Development:
Using "TDD" is beneficial for a few reasons; it can help us focus on / refine requirements,
assures organized code, and improves meeting requirements for development requests.


#### The TDD Cycle:

```
1.  Write a test that fails.
2.  Run tests.
3.  Refactor.
4.  Run tests.
5.  Add tets.
```
This process forces us to constantly refactor our code otherwise it will end up unmaintainable.

## Mocking:
Mocking is a technique for verifying all of our actions added to the Business Rules Engine (BRE) are
actually executed. In this section >> utilize __lib.Mockito__ to import a popular Java mocking library.

```
import static org.mockito.Mockito.*;
```

#### The Mockito Way:

1.	Import Mockito library/module.
2.	Create a mock-ito.
3.	Verify methods are called << by using mock-itos.

#### Two Mockito Modules:
1.	mock() -- creates a mock object to use for verifying behaviors occur.
2.	verify() -- sets up assertions to determine methods are invoked.


## Test Cases:

### [5-17] Enumerating different deal stages:

```
public enum Stage {
    LEAD, INTERESTED, EVALUATING, CLOSED
}
``` 

### [5-18] Rule to calculate a forecast amount for a specific deal:
```
businessRuleEngine.addAction(facts -> {
    var forecastedAmount = 0.0;
    var dealStage = Stage.valueOf(facts.getFact("stage"));
    var amount = Double.parseDouble(facts.getFact("amount"));
    if(dealStage == Stage.LEAD){
        forecastedAmount = amount * 0.2;
    } else if (dealStage == Stage.EVALUATING) {
        forecastedAmount = amount * 0.5;
    } else if(dealStage == Stage.INTERESTED) {
        forecastedAmount = amount * 0.8;
    } else if(dealStage == Stage.CLOSED) {
        forecastedAmount = amount;
    }
    facts.addFact("forecastedAmount", String.valueOf(forecastedAmount));
});
```

### [5-27] A switch case lambada Rule to calculate a forecast amount for a specific deal:

```
businessRuleEngine.addAction(facts -> {
    var dealStage = Stage.valueOf(facts.getFact("stage"));
    var amount = Double.parseDouble(facts.getFact("amount"));
    var forecastedAmount = amount * switch (dealStage) {
        case LEAD -> 0.2;
        case EVALUATING -> 0.5;
        case INTERESTED -> 0.8;
        case CLOSED -> 1;
    }
    facts.addFact("forecastedAmount", String.valueOf(forecastedAmount));
});
```

### [5-28] Creating new rules:

```
final Condition condition = (Facts facts) -> "CEO".equals(facts.getFact("jobTitle"));
final Action action = (Facts facts) -> {
      var name = facts.getFact("name");
      Mailer.sendEmail("sales@company.com", "Relevant customer!!!: " + name);
};

final Rule rule = new DefaultRule(condition, action);
```

### [5-30] Using the RuleBuilder:

1. Initialize RuleBuilder()
2. RuleBuilder.when() >> then() 
```
final Rule ruleSendEmailToSalesWhenCEO = RuleBuilder
        .when(facts -> "CEO".equals(facts.getFact("jobTitle")))
        .then(facts -> {
            var name = facts.getFact("name");
            Mailer.sendEmail("sales@company.com", "Relevant customer!!!: " + name);
        });
```









<!-------------------------------------------------------------------------------->
<!--- tag:in[] --- crystal_Void.css --- README-Version 0.0 --- alexanderfunai.com - [akf7™] --->



<style type="text/css">


		/* <Body> */
body {
width: 100%;
height: 125%;
background-color: #282A36;
color: #ffffff;
font-family: 'Source Sans Pro';
font-size: 13px;
}
		/* </Body> */

  
		/* <Headers> */
  h1 {
  color: #ffebff;
  text-decoration: underline;
  font-size: 29.125px;
  font-family: 'Source Sans Pro';
  }
  
  h2 {
  color: #e6f8ff;
  font-size: 21.825px;
  text-decoration: overline;
  font-family: 'Source Sans Pro';
  }
  
  h3 {
  color: #e6f8ff;
  font-family: 'Source Sans Pro';
  font-size: 15.125px;
  font-weight: lighter;
  }
  
  h4 {
  color: #e6f8ff;
  font-family: 'Source Sans Pro';
  font-weight: lighter;
  }
		/* </Headers> */
  
  
		/* </Code> */
  code {
  color: #36ff9a;
  font-family: 'Source Sans Pro';
  font-size: 11.5px;
  }
		/* </Code> */
  
  
		/* <Href> */
  a:link {
  color: #52b5e3;
  }
		/* </Href> */
  
 
</style>



<!--- tag:out[] --- crystal_Void.css --- README-Version 0.0 --- https://www.alexanderfunai.com [akf7™] --->
<!-------------------------------------------------------------------------------->
