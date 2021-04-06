package Twootr;

import Twootr.InMemory.InMemoryUserRepository;

public class InMemoryUserRepositoryTest extends AbstractUserRepositoryTest {
    
	private InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();

	
    @Override
    protected UserRepository newRepository() {
    	
        return inMemoryUserRepository;
    }
}