package Twootr;


import Twootr.database.DatabaseUserRepository;

public class DatabaseUserRepositoryTest extends AbstractUserRepositoryTest {
    @Override
    protected UserRepository newRepository() {
        return new DatabaseUserRepository();
    }
}
