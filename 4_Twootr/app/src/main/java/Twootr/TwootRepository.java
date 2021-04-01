///////////////////////////////////////////////////////////////////////////////
// Main Class File: Twootr.java
// File: interface.TwootrRepository.java
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

import java.util.Optional;
import java.util.function.Consumer;


/**
 * Method() collection for managing twoots.
 * @author Rauol Gabriel Urma & Richard Warburton.
 */
public interface TwootRepository {
    Twoot add(String id, String userId, String content);
    Optional<Twoot> get(String id);
    void delete(Twoot twoot);
    void query(TwootQuery twootQuery, Consumer<Twoot> callback);
    void clear();
}
