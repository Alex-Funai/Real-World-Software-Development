package Twootr;

import org.junit.Before;

import Twootr.InMemory.InMemoryTwootRepository;

public class InMemoryTwootRepositoryTest extends AbstractTwootRepositoryTest
{
    @Before
    public void setUp()
    {
        repository = new InMemoryTwootRepository();

    }
}