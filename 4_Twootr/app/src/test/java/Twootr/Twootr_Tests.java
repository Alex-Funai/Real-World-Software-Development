package Twootr;

import org.junit.*;

import static junit.framework.TestCase.assertFalse;


public class Twootr_Tests {

    @Test
    public void verifyUserAuthentication() {
        // login message for user
        // login method returns new endpoint
        // assert endpoint is valid.
    }

    @Test
    public void denyUserAuthenticationIfPassword() {

        final Optional<SenderEndPoint> endpoint =
                twootr.onLogon(TestData.USER_ID, "incorrect password", receiverEndPoint);

        assertFalse(endPoint.isPresent());
    }

    @Test
    public void DenyUserDuplicateFollows() {
        logon();

        endPoint.onFollow(TestData.TARGET_ID);

        final RelationshipStatus relationshipStatus = endPoint.onFollow(TestData.TARGET_ID);
        assertEquals(ALREADY_FOLLOWING, relationshipStatus);
    }

}
