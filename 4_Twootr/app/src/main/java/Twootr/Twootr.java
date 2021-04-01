package Twootr;

public class Twootr {


    void onSendTwoot (final String id, final User user, final String content) {

        final String userId = user.getId();
        final Twoot twoot = new Twoot (id, userId, content);

        user.followers().filter(User::isLoggedOn).forEach(follower -> follower.receiveTwoot(twoot));
    }
}
