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

/******************************************************************************
 * @apiNote <-- Using the query -->
 * twootRepository.query(new TwootQuery().inUsers(user.getFollowing()).
 * lastSeenPosition(user.getLastSeenPosition()), user::receiveTwoot);
 ******************************************************************************/

package Twootr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static java.util.Arrays.asList;


/**
 * @author ::Rauol-Gabriel Urma & Richard Warburton
 */
public class TwootQuery {

    private Set<String> inUsers;
    private Position lastSeenPosition;


    /************************************************
     *              Query --> Users::               *
     ************************************************/

    /**
     */
    public Set<String> getInUsers() { return inUsers; }

    /**
     */
    public boolean hasUsers() {
        return inUsers != null && !inUsers.isEmpty();
    }

    /**
     */
    public TwootQuery inUsers(final Set<String> inUsers) {
        this.inUsers = inUsers;
        return this;
    }
    public TwootQuery inUsers(String... inUsers) {
        return inUsers(new HashSet<>(Arrays.asList(inUsers)));
    }


    /************************************************
     *              Query --> Position::            *
     ************************************************/

    /**
     */
    public Position getLastSeenPosition() { return lastSeenPosition; }

    /**
     */
    public TwootQuery lastSeenPosition(final Position lastSeenPosition) {
        this.lastSeenPosition = lastSeenPosition;
        return this;
    }
}

