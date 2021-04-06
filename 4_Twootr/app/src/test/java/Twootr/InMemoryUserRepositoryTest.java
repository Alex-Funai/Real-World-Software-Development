package Twootr;

import org.junit.Before;

public class InMemoryUserRepositoryTest extends AbstractUserRepositoryTest {
    
	private InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();

    @Override
    protected UserRepository newRepository() {
        return inMemoryUserRepository;
    }
}