///////////////////////////////////////////////////////////////////////////////
// Main Class File: Twootr.java
// File: interface.UserRepository.java
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

/**(
 * @author Rauol-Gabriel Urma & Richard Warburton.
 */
public interface UserRepository extends AutoCloseable {

    boolean add(User user);     Optional<User> get(String userId);

    void update(User user);     void clear();

    FollowStatus follow(User follower, User userToFollow);
}
