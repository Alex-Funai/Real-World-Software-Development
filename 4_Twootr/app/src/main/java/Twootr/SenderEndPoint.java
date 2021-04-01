///////////////////////////////////////////////////////////////////////////////
// Main Class File: Twootr.java
// File: class.SenderEndPoint.java
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
import java.util.Objects;

/**
 *
 * @author ::Rauol-Gabriel Urma & Richard Warburton
 */
public class SenderEndPoint {

    private final User user;
    private final Twootr twootr;

    /**
     * @param (user, twootr)
     * @return
     */
    SenderEndPoint(final User user, final Twootr twootr) {
        Objects.requireNonNull(user, "user");
        Objects.requireNonNull(twootr, "twootr");
        this.user = user;
        this.twootr = twootr;
    }

    /**
     * @param followTargetID
     * @return
     */
    public FollowStatus onFollow(final String followTargetID) {
        Objects.requireNonNull(followTargetID, "followTargetID");
        return twootr.onFollow(user, followTargetID);
    }

    /**
     * @param (id, content)
     * @return
     */
    public Position onSendTwoot(final String id, final String content) {
        Objects.requireNonNull(content, "content");

        return twootr.onSendTwoot(id, user, content);
    }
}
