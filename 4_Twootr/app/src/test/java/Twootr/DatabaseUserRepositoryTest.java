package Twootr;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class DatabaseUserRepositoryTest extends AbstractUserRepositoryTest {
    @Override
    protected UserRepository newRepository() {
        return new DatabaseUserRepository();
    }
}
