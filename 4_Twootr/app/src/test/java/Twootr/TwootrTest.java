package Twootr;

import org.junit.Before;
import org.junit.Test;

import java.net.PasswordAuthentication;
import java.util.Optional;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.*;

public class TwootrTest {

    private static final Position POSITION_1 = new Position(0);
    private final ReceiverEndPoint receiverEndPoint = mock(ReceiverEndPoint.class);

    private final TwootRepository twootRepository = spy(new InMemoryTwootRepository());
    private final UserRepository userRepository = new InMemoryUserRepository();

    private Twootr twootr;
    private SenderEndPoint endPoint;


    @Before
    public void setUp() {
        twootr = new Twootr(userRepository, twootRepository);

        assertEquals(RegistrationStatus.SUCCESS, twootr.onRegisterUser(TestData.USER_ID, TestData.PASSWORD));
        assertEquals(RegistrationStatus.SUCCESS, twootr.onRegisterUser(TestData.OTHER_USER_ID, TestData.PASSWORD));
    }

    @Test
    public void verifyUserAuthentication() {
    }

    /**
     * @tase ::Verifies endpoint connections are established between two users.
     *         User should be able to see twoots from other users.
     */
    @Test
    public void verifyFollowerTwootEndpoints() {
        // 1 model sending of a twoot
        // 2 verify onSend() SenderEndPoint
    }

    /**
     * @TestCase ::Deny's user login via authentication, if password is incorrect.
     */
    @Test
    public void denyUserAuthenticationIfPassword() {

        final Optional<SenderEndPoint> endpoint =
                twootr.onLogon(TestData.USER_ID, "incorrect password", receiverEndPoint);

        assertFalse(endpoint.isPresent());
    }

    /**
     * @TestCase ::Verifies user can't establish multiple instances of a follow on another user.
     */
    @Test
    public void denyFollowDuplicate() {
        logon();
        endPoint.onFollow(TestData.OTHER_USER_ID);
        final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);
        assertEquals(FollowStatus.ALREADY_FOLLOWING, followStatus);
    }

    /**
     * @tase ::Verifies user can't follow an unknown user, or one whom blocked/restricted them.
     */
    @Test
    public void denyFollowInvalidUser() {
        logon();
        final FollowStatus followStatus = endPoint.onFollow(TestData.INVALID_USER);
        assertEquals (FollowStatus.INVALID_USER, followStatus);
    }

    /**
     * @tase ::Verifies user can access/see twoots published/sent from their followers.
     */
    @Test
    public void verifyReceiveTwootFromFollowers() {
        logon();
        final String id = "1";
        endPoint.onFollow (TestData.OTHER_USER_ID);

        final SenderEndPoint otherEndPoint = otherLogon();
        otherEndPiont.onSendTwoot(id, Twoot);

        verify (twootRepository).add (id, TestData.OTHER_USER_ID, TestData.TWOOT);
        verify (receiverEndPoint).onTwoot (new Twoot (id, TestData.OTHER_USER_ID, TestData.TWOOT, new Position(0)));
    }

    /**
     * @tase ::Verifies user can
     */
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
