///////////////////////////////////////////////////////////////////////////////
// Title: Twootr (Social Media Platform)
// File: Twootr.java
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
import java.util.Objects;
import java.util.Optional;

/**
 * @author Rauol-Gabriel Urma & Richard Warburton.
 */
public class Twootr {

    private final UserRepository userRepository;
    private final TwootRepository twootRepository;

    /**
     *
     *
     * @param userRepository
     * @param twootRepository
     *
     * @author Rauol-Gabriel Urma & Richard Warburton
     */
    public Twootr(final UserRepository userRepository, final TwootRepository twootRepository) {
        this.userRepository = userRepository;
        this.twootRepository = twootRepository;
    }

    /**
     *
     * @param userId
     * @param password
     * @param receiverEndPoint
     * @return
     */
    public Optional<SenderEndPoint> onLogon(final String userId, final String password, final ReceiverEndPoint receiverEndPoint) {

        Objects.requireNonNull(userId, "userId");
        Objects.requireNonNull(password, "password");

        var authenticatedUser = userRepository.get(userId).filter(userOfSameId -> {
                    var hashedPassword = KeyGenerator.hash(password, userOfSameId.getSalt());
                    return Arrays.equals(hashedPassword, userOfSameId.getPassword());
                });

        authenticatedUser.ifPresent(user -> {
            user.onLogon(receiverEndPoint);
            twootRepository.query(new TwootQuery().inUsers(user.getFollowing()).lastSeenPosition(user.getLastSeenPosition()), user::receiveTwoot);
            userRepository.update(user);
        });
        return authenticatedUser.map(user -> new SenderEndPoint(user, this));
    }

    /**
     *
     * @param userId
     * @param password
     * @return
     */
    public RegistrationStatus onRegisterUser(final String userId, final String password) {
        var salt = KeyGenerator.newSalt();
        var hashedPassword = KeyGenerator.hash(password, salt);
        var user = new User(userId, hashedPassword, salt, Position.INITIAL_POSITION);
        return userRepository.add(user) ? RegistrationStatus.SUCCESS : RegistrationStatus.DUPLICATE;
    }

    /**
     *
     * @param follow
     * @param userIdToFollow
     * @return
     */
    FollowStatus onFollow(final User follow, final String userIdToFollow) {
        return userRepository.get(userIdToFollow).map(userToFollow ->
                userRepository.follow(follow, userToFollow)).orElse(FollowStatus.INVALID_USER);
    }

    /**
     *
     * @param id
     * @param user
     * @param content
     * @return
     */
    Position onSendTwoot(final String id, final User user, final String content) {
        var userId = user.getId();
        var twoot = twootRepository.add(id, userId, content);
        user.followers().filter(User::isLoggedOn).forEach(follower -> {
            follower.receiveTwoot(twoot);
            userRepository.update(follower);
        });
        return twoot.getPosition();
    }

    /**
     *
     * @param userId
     * @param id
     * @return
     */
    DeleteStatus onDeleteTwoot(final String userId, final String id) {

        return twootRepository.get(id).map(twoot -> {
                    var canDeleteTwoot = twoot.getSenderId().equals(userId);
                    if (canDeleteTwoot) {
                        twootRepository.delete(twoot);
                    }
                    return canDeleteTwoot ? DeleteStatus.SUCCESS : DeleteStatus.NOT_YOUR_TWOOT;
        }) .orElse(DeleteStatus.UNKNOWN_TWOOT);
    }
}