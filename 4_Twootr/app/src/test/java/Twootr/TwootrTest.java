package Twootr;

import org.junit.*;
import org.mockito.Mock;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static Twootr.FollowStatus.*;
import static Twootr.ReceiverEndPoint.*;


public class TwootrTest {



    @Test
    public void verifyUserAuthentication() {
        // login message for user
        // login method returns new endpoint
        // assert endpoint is valid.
    }

    @Test
    public void verifyFollowerTwootEndpoints() {
        // 1 model sending of a twoot
        // 2 verify onSend() SenderEndPoint

    }

    @Test
    public void denyUserAuthenticationIfPassword() {

        final Optional<SenderEndPoint> endpoint =
                twootr.onLogon(TestData.USER_ID, "incorrect password", receiverEndPoint);

        assertFalse(endPoint.isPresent());
    }

    @Test
    public void denyFollowDuplicate() {
        logon();

        endPoint.onFollow(TestData.TARGET_ID);

        final RelationStatus relationshipStatus = endPoint.onFollow(TestData.TARGET_ID);
        assertEquals(ALREADY_FOLLOWING, relationshipStatus);
    }

    @Test
    public void denyFollowInvalidUser() {

        logon();

        final FollowStatus followStatus = endPoint.onFollow(TestData.INVALID_USER);

        assertEquals (FollowStatus.INVALID_USER, followStatus);
    }

    @Test
    public void verifyReceiveTwootFromFollowers() {

        final String id = "1";

        logon();

        endPoint.onFollow (TestData.TARGET_USER_ID);

        final SenderEndPoint targetEndPoint = targetLogon();
        targetEndPoint.onSendTwoot (id, TWOOT);

        verify (twootRepository).add (id, TestData.TARGET_USER_ID, TWOOT);
        verify (receiverEndPoint).onTwoot (new Twoot (id, TestData.TARGET_USER_ID, TWOOT, new Position(0)));
    }

    @Test
    public void verifyReceiveReplayTwootAfterLogoff() {

        final String id = "1";

        user.FollowsTargetUser();

        final SenderEndPoint targetEndPoint = targetLogon();
        targetEndPoint.onSendTwoot (id, TWOOT);

        logon();

        verify (receiverEndPoint).onTwoot (twootAt (id, POSITION_1));
    }

}
