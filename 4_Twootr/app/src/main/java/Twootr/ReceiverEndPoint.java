///////////////////////////////////////////////////////////////////////////////
// Main Class File: Twootr.java
// File: interface.ReceiverEndPoint.java
// Date: April 1, 2021
// Programmer: Alexander Kitaro Funai
// Email: alexanderfunai@protonmail.com
// Website: https://www.alexanderfunai.com
///////////////////////////////////////////////////////////////////////////////
// Sources: Real World Software Development
// Authors: Rauol-Gabriel Urma & Richard Warburton
// Sources: github.com/Iteratr-Learning/Real-World-Software-Development.git
///////////////////////////////////////////////////////////////////////////////

package Twootr;

/**
 * Socket endpoint management for twoot handshakes.
 * @author Rauol-Gabriel Urma & Richard Warburton
 */
public interface ReceiverEndPoint {

    void onTwoot(Twoot twoot);
}
