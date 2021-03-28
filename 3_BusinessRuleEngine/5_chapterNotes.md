<!--- 
Alexander Kitaro Funai
March 28, 2021
https://www.alexanderfunai.com
-->

# Chapter 5 Notes:

### [5.1] Test-Driven-Development:
Using "TDD" is beneficial for a few reasons; it can help us focus on / refine requirements,
assures organized code, and improves meeting requirements for development requests.


<h4> The TDD Way </h4>

```
1.  Write a test that fails.
2.  Run tests.
3.  Refactor.
4.  Run tests.
5.  Add tets.
```
This process forces us to constantly refactor our code otherwise it will end up unmaintainable.

### [5.2] Mocking:
Mocking is a technique for verifying all of our actions added to the Business Rules Engine (BRE) are
actually executed. In this section >> utilize __lib.Mockito__ to import a popular Java mocking library.

```
import static org.mockito.Mockito.*;
```

<h4> The Mockito Way: </h4>

1.	Import Mockito library/module.
2.	Create a mock-ito.
3.	Verify methods are called << by using mock-itos.
<br>

<h4> Two Mockito Modules: </h4>
1.	mock() -- creates a mock object to use for verifying behaviors occur.
2.	verify() -- sets up assertions to determine methods are invoked.





<style type="text/css">
/*	akfunai_Readme_Styles00	*/


/* Body and virtual container */
body {
width: 100%;
height: 125%;
background-color: #282A36;
color: white;
font-family: 'Source Sans Pro';
font-size: 12.825px;
}
  
  /* Headers */
  h1, h2, h3, h4, {
	color: pink;
	font-family: 'Source  Pro';
  }
  
  /* Fenced code blocks */
  code {
  color: #50FA7B
  font-family: 'Source Sans Pro';
  font-size: 11.5px;
  }
  
  
/* END[] */  
</style>