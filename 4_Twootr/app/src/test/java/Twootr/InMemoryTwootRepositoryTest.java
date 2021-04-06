package Twootr;

import org.junit.Before;

public class InMemoryTwootRepositoryTest extends AbstractTwootRepositoryTest
{
    @Before
    public void setUp()
    {
        repository = new InMemoryTwootRepository();

    }
}