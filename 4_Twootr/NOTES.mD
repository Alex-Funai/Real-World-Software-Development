<!----------
Name: Alexander Kitaro FUnai
Extra: https://www.alexanderfunai.com
Date: April 1, 2021
Sources: Real World Software Development
Contributions: Rauol-Gabriel Urma & Richard Warburton
Sections: Chapter 6
---------->



# Twootr


## Design Specs
+ Users log in to Twootr with a uniqu9e user ID and password
+ Each user has a set of other users t hey follow
+ Users can send twoot and followers can see immediately, the new twoots.
+ Users should we all twoots from their followers since last logged in.
+ Users should be able to delete twoots. Deleted twoots are updated for other users too.
+ Users can log in from various devices.

## Modeling Errors:
+ What if user password doesn't correspond to user --> Use boolean value to indicate match, or enumation
	to verify the match. Enumerations can be used with interfaces and classes.
+ What if user already follows a person and tries to again, or repeats any functions that have a status already set?

#### h4[li]

1.	Lorem ipsum
2.	Lorem Ipsum
3.	PenisHeadElites

### h3[sub]

Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

```
CODE[fenced-cmnt-blk]
```


## Client-Server Model:
Twootr Server <--> Users

### Pull-Based
Pull-based comunnication styl9e makes request to the server and queries for the information. Also known as point-to-point or request-resposne.
Common communication style used by http sites/apps. Client request for data <-> Server responds with data.

### Push-Based
Server ---> data pushed ---> client


## Communication:
### WebSockets:
TCP/IP protocol for event over TCP stream. Often used in event-driven communication between web browsers and servers.
```
// Comms
Server --> Android Push Notifications -- >> Mobile
Server <--> WebSockets <--> Website
```
### Hosted Cloud Message Queue:
Amazon Simple Queue Service, Aeron, ZeroMQ, AMPQ.

```
CODE[fenced-cmnt-blk]
```
## Hexagonal Architecture:
Ports and Adapters || Hexagonal arcitecture introduced by Alister Cockburn.
```
Website -> WebSocket Adapter --> **Core Business Logic** <-- SQL Adapter <-- SQL Database 
Test Harness >-- **Core Business Logic** --< In Memory Adapater
```
### Authentication Services:
OAUTH google API.

### Hashing
Utilize scrypt hashing algorithm. Iplement salt to prevent reverse hashing from brute-force and rainbow tables. Salts add extra randomly generated
input to each password. Attackers would need to know the hashing function and salt to reverse hash the strings.

### Man in the Middle
MIM occurs on TCP/IP Network Layer. Using TLS beneath Application layer can provide a subtle form of defense when utilizing WebSocket connections.

## HashCode()
```Associate positions vs. Points using hashcode for each Twoot.```

1. Create a result variable and assign it a prime number.
2. Take each field that is used by the equals() method and compute an int value to represent the hashcode of the field.
3. Combine the hashcode from the field w/ the existing result by multiplying the previous result by a prime number.

```
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

final Point p1 = new Point(1, 2);
final Point p2 = new Point(1, 2);
System.out.println(p1.equals(p2)); // prints true
```

+ If primitive value, use hashcode on it's class.
	+ Ex: double -> Double.hashCode()
+ If nonnull object -> hashCode() -> java.lang.Objects.hashCode()
+ If an array -> java.util.Arrays.hashCode()

## Repositories:
Create a repository including an object for Twoot and Users. Repositories store collections of objects and commonly have
operations such as:
+ add()
+ get()
+ delete()
+ update()

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
