///////////////////////////////////////////////////////////////////////////////
// Main Class File: Twootr.java
// File: class.User.java
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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Structure and methods() for a twootr account.
 * @author ::Rauol-Gabriel Urma & Richard Warburton.
 */
public class User {

    private final String id;
    private final byte[] password;
    private final byte[] salt;
    private final Set<User> followers = new HashSet<>();
    private final Set<String> following = new HashSet<>();

    private Position lastSeenPosition;
    private ReceiverEndPoint receiverEndPoint;

    /**
     * Definition of a twoot user. \\
     * @param id
     * @param password
     * @param salt
     * @param lastSeenPosition
     */
    public User(final String id, final byte[] password, final byte[] salt, final Position lastSeenPosition) {

        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(password, "password");

        this.id = id;
        this.password = password;
        this.salt = salt;
        this.lastSeenPosition = lastSeenPosition;
    }

    public byte[] getPassword() {
        return password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public String getId() {
        return id;
    }

    boolean receiveTwoot (final Twoot twoot) {
        if (isLoggedOn()) {
            receiverEndPoint.onTwoot(twoot);
            lastSeenPosition = twoot.getPosition();
            return true;
        }
        return false;
    }

    boolean isLoggedOn() {
        return receiverEndPoint != null;
    }

    public FollowStatus addFollower (final User user) {
        if (followers.add(user)) {
            user.following.add(id);
            return FollowStatus.SUCCESS;
        } else {
            return FollowStatus.ALREADY_FOLLOWING;
        }
    }

    void onLogon (final ReceiverEndPoint receiverEndPoint) {
        this.receiverEndPoint = receiverEndPoint;
    }

    void onLogoff() {
        receiverEndPoint = null;
    }

    Stream<User> followers() {
        return followers.stream();
    }

    Set<String> getFollowing() {
        return following;
    }

    public Position getLastSeenPosition() {
        return lastSeenPosition;
    }

    @Override
    public String toString() {
        return "user{" + "id='" + id + '\'' + '}';
    }

}
