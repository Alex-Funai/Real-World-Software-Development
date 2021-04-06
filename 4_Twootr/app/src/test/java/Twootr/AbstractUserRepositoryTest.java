///////////////////////////////////////////////////////////////////////////////
// File: class.AbstractUserRepositoryTest.java
// Date: April 6, 2021
// Programmer: Alexander Kitaro Funai
// Email: alexanderfunai@protonmail.com
// Website: https://www.alexanderfunai.com
///////////////////////////////////////////////////////////////////////////////
// Sources: Real World Software Development
// Authors: Rauol-Gabriel Urma & Richard Warburton
// Sources: github.com/Iteratr-Learning/Real-World-Software-Development.git
///////////////////////////////////////////////////////////////////////////////


package Twootr;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matcher;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


@Ignore("abstract base test")
public abstract class AbstractUserRepositoryTest
{
    private ReceiverEndPoint receiverEndPoint = mock(ReceiverEndPoint.class);
    private UserRepository repository;

    protected abstract UserRepository newRepository();

    @Before
    public void setUp()
    {
        repository = newRepository();

        repository.clear();
    }

    @Test
    public void shouldLoadSavedUsers()
    {
        repository.add(userWith(TestData.USER_ID));

        assertThat(repository.get(TestData.USER_ID).get(),matchesUser());
    }

    @Test
    public void shouldNotAllowDuplicateUsers()
    {
        assertTrue(repository.add(userWith(TestData.USER_ID)));

        assertFalse(repository.add(userWith(TestData.USER_ID)));
    }

    @Test
    public void shouldRecordFollowerRelationships()
    {
        final User user = userWith(TestData.USER_ID);
        final User otherUser = userWith(TestData.OTHER_USER_ID);

        repository.add(user);
        repository.add(otherUser);
        repository.follow(user, otherUser);

        final UserRepository reloadedRepository = newRepository();
        final User userReloaded = reloadedRepository.get(TestData.USER_ID).get();
        final User otherUserReloaded = reloadedRepository.get(TestData.OTHER_USER_ID).get();
        assertEquals(FollowStatus.ALREADY_FOLLOWING, otherUserReloaded.addFollower(userReloaded));
    }

    @Test
    public void shouldRecordPositionUpdates()
    {
        final String id = "1";

        final Position newPosition = new Position(2);
        final User user = userWith(TestData.USER_ID);
        repository.add(user);
        assertEquals(Position.INITIAL_POSITION, user.getLastSeenPosition());

        user.receiveTwoot(TestData.twootAt(id, newPosition));
        repository.update(user);

        final UserRepository reloadedRepository = newRepository();
        final User reloadedUser = reloadedRepository.get(TestData.USER_ID).get();
        assertEquals(newPosition, user.getLastSeenPosition());
        assertEquals(newPosition, reloadedUser.getLastSeenPosition());
    }

    @After
    public void shutdown() throws Exception
    {
        repository.close();
    }

    private User userWith(final String userId)
    {
        final User user = new User(userId, TestData.PASSWORD_BYTES, TestData.SALT, Position.INITIAL_POSITION);
        user.onLogon(receiverEndPoint);
        return user;
    }

    private Matcher<User> matchesUser()
    {
        return allOf(
            hasProperty("id", equalTo(TestData.USER_ID)),
            hasProperty("password", equalTo(TestData.PASSWORD_BYTES)));
    }
}
