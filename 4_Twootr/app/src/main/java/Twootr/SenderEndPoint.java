package Twootr;

import java.util.Objects;

public class SenderEndPoint {

    private final User user;
    private final Twootr twootr;

    SenderEndPoint(final User user, final Twootr twootr) {
        Objects.requireNonNull(user, "user");
        Objects.requireNonNull(twootr, "twootr");
        this.user = user;
        this.twootr = twootr;
    }

    public FollowStatus onFollow(final String followTargetID) {
        Objects.requireNonNull(followTargetID, "followTargetID");
        return twootr.onFollow(user, followTargetID);
    }


}
