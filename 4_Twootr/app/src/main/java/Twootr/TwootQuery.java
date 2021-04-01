///////////////////////////////////////////////////////////////////////////////
// Main Class File: Twootr.java
// File: class.TwootQuery.java
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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

/* Example Using Query::
    twootRepository.query(
    new TwootQuery()
        .inUsers(user.getFollowing())
        .lastSeenPosition(user.getLastSeenPosition()),
    user::receiveTwoot);
 */

/**
 *
 * @author Rauol-Gabriel Urma & Richard Warburton
 */
public class TwootQuery {

    private Set<String> inUsers;
    private Position lastSeenPosition;

    /**
     *
     * @return
     */
    public Set<String> getInUsers() {
        return inUsers;
    }

    /**
     *
     * @return
     */
    public Position getLastSeenPosition() {
        return lastSeenPosition;
    }

    /**
     *
     * @return
     */
    public TwootQuery inUsers(final Set<String> inUsers) {
        this.inUsers = inUsers;
        return this;
    }

    /**
     *
     * @return
     */
    public TwootQuery inUsers(String... inUsers) {
        return inUsers(new HashSet<>(Arrays.asList(inUsers)));
    }

    /**
     *
     * @return
     */
    public TwootQuery lastSeenPosition(final Position lastSeenPosition) {
        this.lastSeenPosition = lastSeenPosition;
        return this;
    }

    /**
     *
     * @return
     */
    public boolean hasUsers() {
        return inUsers != null && !inUsers.isEmpty();
    }
}